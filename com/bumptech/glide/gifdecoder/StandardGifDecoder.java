package com.bumptech.glide.gifdecoder;

import android.graphics.Bitmap;
import android.util.Log;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.gifdecoder.GifDecoder;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.Iterator;
/* loaded from: classes14.dex */
public class StandardGifDecoder implements GifDecoder {
    private static final int BYTES_PER_INTEGER = 4;
    @ColorInt
    private static final int COLOR_TRANSPARENT_BLACK = 0;
    private static final int INITIAL_FRAME_POINTER = -1;
    private static final int MASK_INT_LOWEST_BYTE = 255;
    private static final int MAX_STACK_SIZE = 4096;
    private static final int NULL_CODE = -1;
    private static final String TAG = StandardGifDecoder.class.getSimpleName();
    @ColorInt
    private int[] act;
    @NonNull
    private Bitmap.Config bitmapConfig;
    private final GifDecoder.BitmapProvider bitmapProvider;
    private byte[] block;
    private int downsampledHeight;
    private int downsampledWidth;
    private int framePointer;
    private GifHeader header;
    @Nullable
    private Boolean isFirstFrameTransparent;
    private byte[] mainPixels;
    @ColorInt
    private int[] mainScratch;
    private GifHeaderParser parser;
    @ColorInt
    private final int[] pct;
    private byte[] pixelStack;
    private short[] prefix;
    private Bitmap previousImage;
    private ByteBuffer rawData;
    private int sampleSize;
    private boolean savePrevious;
    private int status;
    private byte[] suffix;

    public StandardGifDecoder(@NonNull GifDecoder.BitmapProvider bitmapProvider, GifHeader gifHeader, ByteBuffer byteBuffer) {
        this(bitmapProvider, gifHeader, byteBuffer, 1);
    }

    public StandardGifDecoder(@NonNull GifDecoder.BitmapProvider bitmapProvider, GifHeader gifHeader, ByteBuffer byteBuffer, int i) {
        this(bitmapProvider);
        setData(gifHeader, byteBuffer, i);
    }

    public StandardGifDecoder(@NonNull GifDecoder.BitmapProvider bitmapProvider) {
        this.pct = new int[256];
        this.bitmapConfig = Bitmap.Config.ARGB_8888;
        this.bitmapProvider = bitmapProvider;
        this.header = new GifHeader();
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public int getWidth() {
        return this.header.width;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public int getHeight() {
        return this.header.height;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    @NonNull
    public ByteBuffer getData() {
        return this.rawData;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public int getStatus() {
        return this.status;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public void advance() {
        this.framePointer = (this.framePointer + 1) % this.header.frameCount;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public int getDelay(int i) {
        if (i < 0 || i >= this.header.frameCount) {
            return -1;
        }
        return this.header.frames.get(i).delay;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public int getNextDelay() {
        if (this.header.frameCount <= 0 || this.framePointer < 0) {
            return 0;
        }
        return getDelay(this.framePointer);
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public int getFrameCount() {
        return this.header.frameCount;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public int getCurrentFrameIndex() {
        return this.framePointer;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public void resetFrameIndex() {
        this.framePointer = -1;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    @Deprecated
    public int getLoopCount() {
        if (this.header.loopCount == -1) {
            return 1;
        }
        return this.header.loopCount;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public int getNetscapeLoopCount() {
        return this.header.loopCount;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public int getTotalIterationCount() {
        if (this.header.loopCount == -1) {
            return 1;
        }
        if (this.header.loopCount == 0) {
            return 0;
        }
        return this.header.loopCount + 1;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public int getByteSize() {
        return this.rawData.limit() + this.mainPixels.length + (this.mainScratch.length * 4);
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    @Nullable
    public synchronized Bitmap getNextFrame() {
        Bitmap bitmap;
        if (this.header.frameCount <= 0 || this.framePointer < 0) {
            if (Log.isLoggable(TAG, 3)) {
                Log.d(TAG, "Unable to decode frame, frameCount=" + this.header.frameCount + ", framePointer=" + this.framePointer);
            }
            this.status = 1;
        }
        if (this.status == 1 || this.status == 2) {
            if (Log.isLoggable(TAG, 3)) {
                Log.d(TAG, "Unable to decode frame, status=" + this.status);
            }
            bitmap = null;
        } else {
            this.status = 0;
            if (this.block == null) {
                this.block = this.bitmapProvider.obtainByteArray(255);
            }
            GifFrame gifFrame = this.header.frames.get(this.framePointer);
            int i = this.framePointer - 1;
            GifFrame gifFrame2 = i >= 0 ? this.header.frames.get(i) : null;
            this.act = gifFrame.lct != null ? gifFrame.lct : this.header.gct;
            if (this.act == null) {
                if (Log.isLoggable(TAG, 3)) {
                    Log.d(TAG, "No valid color table found for frame #" + this.framePointer);
                }
                this.status = 1;
                bitmap = null;
            } else {
                if (gifFrame.transparency) {
                    System.arraycopy(this.act, 0, this.pct, 0, this.act.length);
                    this.act = this.pct;
                    this.act[gifFrame.transIndex] = 0;
                }
                bitmap = setPixels(gifFrame, gifFrame2);
            }
        }
        return bitmap;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public int read(@Nullable InputStream inputStream, int i) {
        if (inputStream != null) {
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(i > 0 ? i + 4096 : 16384);
                byte[] bArr = new byte[16384];
                while (true) {
                    int read = inputStream.read(bArr, 0, bArr.length);
                    if (read == -1) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, read);
                }
                byteArrayOutputStream.flush();
                read(byteArrayOutputStream.toByteArray());
            } catch (IOException e) {
                Log.w(TAG, "Error reading data from stream", e);
            }
        } else {
            this.status = 2;
        }
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e2) {
                Log.w(TAG, "Error closing stream", e2);
            }
        }
        return this.status;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public void clear() {
        this.header = null;
        if (this.mainPixels != null) {
            this.bitmapProvider.release(this.mainPixels);
        }
        if (this.mainScratch != null) {
            this.bitmapProvider.release(this.mainScratch);
        }
        if (this.previousImage != null) {
            this.bitmapProvider.release(this.previousImage);
        }
        this.previousImage = null;
        this.rawData = null;
        this.isFirstFrameTransparent = null;
        if (this.block != null) {
            this.bitmapProvider.release(this.block);
        }
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public synchronized void setData(@NonNull GifHeader gifHeader, @NonNull byte[] bArr) {
        setData(gifHeader, ByteBuffer.wrap(bArr));
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public synchronized void setData(@NonNull GifHeader gifHeader, @NonNull ByteBuffer byteBuffer) {
        setData(gifHeader, byteBuffer, 1);
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public synchronized void setData(@NonNull GifHeader gifHeader, @NonNull ByteBuffer byteBuffer, int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("Sample size must be >=0, not: " + i);
        }
        int highestOneBit = Integer.highestOneBit(i);
        this.status = 0;
        this.header = gifHeader;
        this.framePointer = -1;
        this.rawData = byteBuffer.asReadOnlyBuffer();
        this.rawData.position(0);
        this.rawData.order(ByteOrder.LITTLE_ENDIAN);
        this.savePrevious = false;
        Iterator<GifFrame> it = gifHeader.frames.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            } else if (it.next().dispose == 3) {
                this.savePrevious = true;
                break;
            }
        }
        this.sampleSize = highestOneBit;
        this.downsampledWidth = gifHeader.width / highestOneBit;
        this.downsampledHeight = gifHeader.height / highestOneBit;
        this.mainPixels = this.bitmapProvider.obtainByteArray(gifHeader.width * gifHeader.height);
        this.mainScratch = this.bitmapProvider.obtainIntArray(this.downsampledWidth * this.downsampledHeight);
    }

    @NonNull
    private GifHeaderParser getHeaderParser() {
        if (this.parser == null) {
            this.parser = new GifHeaderParser();
        }
        return this.parser;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public synchronized int read(@Nullable byte[] bArr) {
        this.header = getHeaderParser().setData(bArr).parseHeader();
        if (bArr != null) {
            setData(this.header, bArr);
        }
        return this.status;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public void setDefaultBitmapConfig(@NonNull Bitmap.Config config) {
        if (config != Bitmap.Config.ARGB_8888 && config != Bitmap.Config.RGB_565) {
            throw new IllegalArgumentException("Unsupported format: " + config + ", must be one of " + Bitmap.Config.ARGB_8888 + " or " + Bitmap.Config.RGB_565);
        }
        this.bitmapConfig = config;
    }

    private Bitmap setPixels(GifFrame gifFrame, GifFrame gifFrame2) {
        int i;
        int[] iArr = this.mainScratch;
        if (gifFrame2 == null) {
            if (this.previousImage != null) {
                this.bitmapProvider.release(this.previousImage);
            }
            this.previousImage = null;
            Arrays.fill(iArr, 0);
        }
        if (gifFrame2 != null && gifFrame2.dispose == 3 && this.previousImage == null) {
            Arrays.fill(iArr, 0);
        }
        if (gifFrame2 != null && gifFrame2.dispose > 0) {
            if (gifFrame2.dispose == 2) {
                if (!gifFrame.transparency) {
                    i = this.header.bgColor;
                    if (gifFrame.lct != null && this.header.bgIndex == gifFrame.transIndex) {
                        i = 0;
                    }
                } else {
                    if (this.framePointer == 0) {
                        this.isFirstFrameTransparent = true;
                    }
                    i = 0;
                }
                int i2 = gifFrame2.ih / this.sampleSize;
                int i3 = gifFrame2.iy / this.sampleSize;
                int i4 = gifFrame2.iw / this.sampleSize;
                int i5 = (i3 * this.downsampledWidth) + (gifFrame2.ix / this.sampleSize);
                int i6 = i5 + (i2 * this.downsampledWidth);
                while (i5 < i6) {
                    int i7 = i5 + i4;
                    for (int i8 = i5; i8 < i7; i8++) {
                        iArr[i8] = i;
                    }
                    i5 += this.downsampledWidth;
                }
            } else if (gifFrame2.dispose == 3 && this.previousImage != null) {
                this.previousImage.getPixels(iArr, 0, this.downsampledWidth, 0, 0, this.downsampledWidth, this.downsampledHeight);
            }
        }
        decodeBitmapData(gifFrame);
        if (gifFrame.interlace || this.sampleSize != 1) {
            copyCopyIntoScratchRobust(gifFrame);
        } else {
            copyIntoScratchFast(gifFrame);
        }
        if (this.savePrevious && (gifFrame.dispose == 0 || gifFrame.dispose == 1)) {
            if (this.previousImage == null) {
                this.previousImage = getNextBitmap();
            }
            this.previousImage.setPixels(iArr, 0, this.downsampledWidth, 0, 0, this.downsampledWidth, this.downsampledHeight);
        }
        Bitmap nextBitmap = getNextBitmap();
        nextBitmap.setPixels(iArr, 0, this.downsampledWidth, 0, 0, this.downsampledWidth, this.downsampledHeight);
        return nextBitmap;
    }

    private void copyIntoScratchFast(GifFrame gifFrame) {
        int[] iArr = this.mainScratch;
        int i = gifFrame.ih;
        int i2 = gifFrame.iy;
        int i3 = gifFrame.iw;
        int i4 = gifFrame.ix;
        boolean z = this.framePointer == 0;
        int i5 = this.downsampledWidth;
        byte[] bArr = this.mainPixels;
        int[] iArr2 = this.act;
        byte b2 = -1;
        for (int i6 = 0; i6 < i; i6++) {
            int i7 = (i6 + i2) * i5;
            int i8 = i7 + i4;
            int i9 = i8 + i3;
            if (i7 + i5 < i9) {
                i9 = i7 + i5;
            }
            int i10 = gifFrame.iw * i6;
            while (i8 < i9) {
                byte b3 = bArr[i10];
                int i11 = b3 & 255;
                if (i11 != b2) {
                    int i12 = iArr2[i11];
                    if (i12 != 0) {
                        iArr[i8] = i12;
                    } else {
                        b2 = b3;
                    }
                }
                i8++;
                i10++;
            }
        }
        this.isFirstFrameTransparent = Boolean.valueOf(this.isFirstFrameTransparent == null && z && b2 != -1);
    }

    private void copyCopyIntoScratchRobust(GifFrame gifFrame) {
        int i;
        int i2;
        int i3;
        int i4;
        int[] iArr = this.mainScratch;
        int i5 = gifFrame.ih / this.sampleSize;
        int i6 = gifFrame.iy / this.sampleSize;
        int i7 = gifFrame.iw / this.sampleSize;
        int i8 = gifFrame.ix / this.sampleSize;
        int i9 = 1;
        int i10 = 8;
        int i11 = 0;
        boolean z = this.framePointer == 0;
        int i12 = this.sampleSize;
        int i13 = this.downsampledWidth;
        int i14 = this.downsampledHeight;
        byte[] bArr = this.mainPixels;
        int[] iArr2 = this.act;
        Boolean bool = this.isFirstFrameTransparent;
        int i15 = 0;
        while (i15 < i5) {
            if (gifFrame.interlace) {
                if (i11 >= i5) {
                    i9++;
                    switch (i9) {
                        case 2:
                            i11 = 4;
                            break;
                        case 3:
                            i11 = 2;
                            i10 = 4;
                            break;
                        case 4:
                            i11 = 1;
                            i10 = 2;
                            break;
                    }
                }
                i2 = i11 + i10;
                i = i11;
                i3 = i10;
                i4 = i9;
            } else {
                i = i15;
                i2 = i11;
                i3 = i10;
                i4 = i9;
            }
            int i16 = i + i6;
            boolean z2 = i12 == 1;
            if (i16 < i14) {
                int i17 = i16 * i13;
                int i18 = i17 + i8;
                int i19 = i18 + i7;
                if (i17 + i13 < i19) {
                    i19 = i17 + i13;
                }
                int i20 = i15 * i12 * gifFrame.iw;
                if (z2) {
                    Boolean bool2 = bool;
                    while (i18 < i19) {
                        int i21 = iArr2[bArr[i20] & 255];
                        if (i21 != 0) {
                            iArr[i18] = i21;
                        } else if (z && bool2 == null) {
                            bool2 = true;
                        }
                        i20 += i12;
                        i18++;
                    }
                    bool = bool2;
                } else {
                    int i22 = i20 + ((i19 - i18) * i12);
                    Boolean bool3 = bool;
                    while (i18 < i19) {
                        int averageColorsNear = averageColorsNear(i20, i22, gifFrame.iw);
                        if (averageColorsNear != 0) {
                            iArr[i18] = averageColorsNear;
                        } else if (z && bool3 == null) {
                            bool3 = true;
                        }
                        i20 += i12;
                        i18++;
                    }
                    bool = bool3;
                }
            }
            i15++;
            i11 = i2;
            i10 = i3;
            i9 = i4;
        }
        if (this.isFirstFrameTransparent == null) {
            this.isFirstFrameTransparent = Boolean.valueOf(bool == null ? false : bool.booleanValue());
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x006b, code lost:
        return 0;
     */
    @ColorInt
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int averageColorsNear(int i, int i2, int i3) {
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        for (int i9 = i; i9 < this.sampleSize + i && i9 < this.mainPixels.length && i9 < i2; i9++) {
            int i10 = this.act[this.mainPixels[i9] & 255];
            if (i10 != 0) {
                i8 += (i10 >> 24) & 255;
                i7 += (i10 >> 16) & 255;
                i6 += (i10 >> 8) & 255;
                i5 += i10 & 255;
                i4++;
            }
        }
        for (int i11 = i + i3; i11 < i + i3 + this.sampleSize && i11 < this.mainPixels.length && i11 < i2; i11++) {
            int i12 = this.act[this.mainPixels[i11] & 255];
            if (i12 != 0) {
                i8 += (i12 >> 24) & 255;
                i7 += (i12 >> 16) & 255;
                i6 += (i12 >> 8) & 255;
                i5 += i12 & 255;
                i4++;
            }
        }
        return ((i8 / i4) << 24) | ((i7 / i4) << 16) | ((i6 / i4) << 8) | (i5 / i4);
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:81:0x010c */
    /* JADX DEBUG: Multi-variable search result rejected for r2v39, resolved type: short */
    /* JADX WARN: Multi-variable type inference failed */
    private void decodeBitmapData(GifFrame gifFrame) {
        int i;
        short s;
        int i2;
        int i3;
        if (gifFrame != null) {
            this.rawData.position(gifFrame.bufferFrameStart);
        }
        int i4 = gifFrame == null ? this.header.width * this.header.height : gifFrame.iw * gifFrame.ih;
        if (this.mainPixels == null || this.mainPixels.length < i4) {
            this.mainPixels = this.bitmapProvider.obtainByteArray(i4);
        }
        byte[] bArr = this.mainPixels;
        if (this.prefix == null) {
            this.prefix = new short[4096];
        }
        short[] sArr = this.prefix;
        if (this.suffix == null) {
            this.suffix = new byte[4096];
        }
        byte[] bArr2 = this.suffix;
        if (this.pixelStack == null) {
            this.pixelStack = new byte[4097];
        }
        byte[] bArr3 = this.pixelStack;
        int readByte = readByte();
        int i5 = 1 << readByte;
        int i6 = i5 + 1;
        int i7 = i5 + 2;
        int i8 = -1;
        int i9 = readByte + 1;
        int i10 = (1 << i9) - 1;
        for (int i11 = 0; i11 < i5; i11++) {
            sArr[i11] = 0;
            bArr2[i11] = (byte) i11;
        }
        byte[] bArr4 = this.block;
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        int i15 = 0;
        int i16 = 0;
        int i17 = 0;
        int i18 = 0;
        int i19 = 0;
        while (true) {
            if (i17 >= i4) {
                break;
            }
            if (i18 == 0) {
                i18 = readBlock();
                if (i18 <= 0) {
                    this.status = 3;
                    break;
                }
                i13 = 0;
            }
            i19 += 8;
            int i20 = i13 + 1;
            int i21 = i18 - 1;
            int i22 = i15;
            i16 = ((bArr4[i13] & 255) << i19) + i16;
            while (true) {
                if (i19 < i9) {
                    i13 = i20;
                    i15 = i22;
                    i18 = i21;
                    break;
                }
                int i23 = i16 & i10;
                i16 >>= i9;
                i19 -= i9;
                if (i23 == i5) {
                    i9 = readByte + 1;
                    i10 = (1 << i9) - 1;
                    i7 = i5 + 2;
                    i8 = -1;
                } else if (i23 == i6) {
                    i13 = i20;
                    i15 = i22;
                    i18 = i21;
                    break;
                } else if (i8 == -1) {
                    bArr[i12] = bArr2[i23];
                    i12++;
                    i22 = i23;
                    i17++;
                    i8 = i23;
                } else {
                    if (i23 >= i7) {
                        bArr3[i14] = (byte) i22;
                        i = i14 + 1;
                        s = i8;
                    } else {
                        i = i14;
                        s = i23;
                    }
                    while (s >= i5) {
                        bArr3[i] = bArr2[s];
                        i++;
                        s = sArr[s];
                    }
                    i22 = bArr2[s] & 255;
                    bArr[i12] = (byte) i22;
                    int i24 = i17 + 1;
                    i12++;
                    i14 = i;
                    while (i14 > 0) {
                        int i25 = i14 - 1;
                        bArr[i12] = bArr3[i25];
                        i24++;
                        i12++;
                        i14 = i25;
                    }
                    if (i7 < 4096) {
                        sArr[i7] = (short) i8;
                        bArr2[i7] = (byte) i22;
                        i7++;
                        if ((i7 & i10) == 0 && i7 < 4096) {
                            i2 = i9 + 1;
                            i3 = i10 + i7;
                            i17 = i24;
                            i8 = i23;
                            i9 = i2;
                            i10 = i3;
                        }
                    }
                    i2 = i9;
                    i3 = i10;
                    i17 = i24;
                    i8 = i23;
                    i9 = i2;
                    i10 = i3;
                }
            }
        }
        Arrays.fill(bArr, i12, i4, (byte) 0);
    }

    private int readByte() {
        return this.rawData.get() & 255;
    }

    private int readBlock() {
        int readByte = readByte();
        if (readByte > 0) {
            this.rawData.get(this.block, 0, Math.min(readByte, this.rawData.remaining()));
        }
        return readByte;
    }

    private Bitmap getNextBitmap() {
        Bitmap obtain = this.bitmapProvider.obtain(this.downsampledWidth, this.downsampledHeight, (this.isFirstFrameTransparent == null || this.isFirstFrameTransparent.booleanValue()) ? Bitmap.Config.ARGB_8888 : this.bitmapConfig);
        obtain.setHasAlpha(true);
        return obtain;
    }
}
