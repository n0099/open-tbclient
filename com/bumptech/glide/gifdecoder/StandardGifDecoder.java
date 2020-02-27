package com.bumptech.glide.gifdecoder;

import android.graphics.Bitmap;
import android.support.annotation.ColorInt;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import com.bumptech.glide.gifdecoder.GifDecoder;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.Iterator;
/* loaded from: classes6.dex */
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
        byte b = -1;
        int i6 = 0;
        while (i6 < i) {
            int i7 = (i6 + i2) * i5;
            int i8 = i7 + i4;
            int i9 = i8 + i3;
            if (i7 + i5 < i9) {
                i9 = i7 + i5;
            }
            int i10 = i8;
            byte b2 = b;
            int i11 = gifFrame.iw * i6;
            while (i10 < i9) {
                byte b3 = bArr[i11];
                int i12 = b3 & 255;
                if (i12 != b2) {
                    int i13 = iArr2[i12];
                    if (i13 != 0) {
                        iArr[i10] = i13;
                    } else {
                        b2 = b3;
                    }
                }
                i10++;
                i11++;
            }
            i6++;
            b = b2;
        }
        this.isFirstFrameTransparent = Boolean.valueOf(this.isFirstFrameTransparent == null && z && b != -1);
    }

    private void copyCopyIntoScratchRobust(GifFrame gifFrame) {
        int i;
        int i2;
        int i3;
        Boolean bool;
        int[] iArr = this.mainScratch;
        int i4 = gifFrame.ih / this.sampleSize;
        int i5 = gifFrame.iy / this.sampleSize;
        int i6 = gifFrame.iw / this.sampleSize;
        int i7 = gifFrame.ix / this.sampleSize;
        int i8 = 1;
        int i9 = 8;
        int i10 = 0;
        boolean z = this.framePointer == 0;
        int i11 = this.sampleSize;
        int i12 = this.downsampledWidth;
        int i13 = this.downsampledHeight;
        byte[] bArr = this.mainPixels;
        int[] iArr2 = this.act;
        Boolean bool2 = this.isFirstFrameTransparent;
        int i14 = 0;
        while (i14 < i4) {
            if (gifFrame.interlace) {
                if (i10 >= i4) {
                    i8++;
                    switch (i8) {
                        case 2:
                            i10 = 4;
                            break;
                        case 3:
                            i10 = 2;
                            i9 = 4;
                            break;
                        case 4:
                            i10 = 1;
                            i9 = 2;
                            break;
                    }
                }
                i = i10 + i9;
                i2 = i9;
                i3 = i8;
            } else {
                i = i10;
                i2 = i9;
                i3 = i8;
                i10 = i14;
            }
            int i15 = i10 + i5;
            boolean z2 = i11 == 1;
            if (i15 < i13) {
                int i16 = i15 * i12;
                int i17 = i16 + i7;
                int i18 = i17 + i6;
                if (i16 + i12 < i18) {
                    i18 = i16 + i12;
                }
                int i19 = i14 * i11 * gifFrame.iw;
                if (z2) {
                    bool = bool2;
                    int i20 = i19;
                    for (int i21 = i17; i21 < i18; i21++) {
                        int i22 = iArr2[bArr[i20] & 255];
                        if (i22 != 0) {
                            iArr[i21] = i22;
                        } else if (z && bool == null) {
                            bool = true;
                        }
                        i20 += i11;
                    }
                } else {
                    int i23 = ((i18 - i17) * i11) + i19;
                    bool = bool2;
                    int i24 = i19;
                    for (int i25 = i17; i25 < i18; i25++) {
                        int averageColorsNear = averageColorsNear(i24, i23, gifFrame.iw);
                        if (averageColorsNear != 0) {
                            iArr[i25] = averageColorsNear;
                        } else if (z && bool == null) {
                            bool = true;
                        }
                        i24 += i11;
                    }
                }
            } else {
                bool = bool2;
            }
            i14++;
            bool2 = bool;
            i10 = i;
            i8 = i3;
            i9 = i2;
        }
        if (this.isFirstFrameTransparent == null) {
            this.isFirstFrameTransparent = Boolean.valueOf(bool2 == null ? false : bool2.booleanValue());
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

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:80:0x0123 */
    /* JADX DEBUG: Multi-variable search result rejected for r5v22, resolved type: short */
    /* JADX WARN: Multi-variable type inference failed */
    private void decodeBitmapData(GifFrame gifFrame) {
        short s;
        if (gifFrame != null) {
            this.rawData.position(gifFrame.bufferFrameStart);
        }
        int i = gifFrame == null ? this.header.width * this.header.height : gifFrame.iw * gifFrame.ih;
        if (this.mainPixels == null || this.mainPixels.length < i) {
            this.mainPixels = this.bitmapProvider.obtainByteArray(i);
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
        int i2 = 1 << readByte;
        int i3 = i2 + 1;
        int i4 = i2 + 2;
        int i5 = readByte + 1;
        int i6 = (1 << i5) - 1;
        for (int i7 = 0; i7 < i2; i7++) {
            sArr[i7] = 0;
            bArr2[i7] = (byte) i7;
        }
        byte[] bArr4 = this.block;
        int i8 = 0;
        int i9 = 0;
        int i10 = 0;
        int i11 = 0;
        int i12 = -1;
        int i13 = i5;
        int i14 = i6;
        int i15 = i4;
        int i16 = 0;
        int i17 = 0;
        int i18 = 0;
        int i19 = 0;
        while (true) {
            if (i8 >= i) {
                break;
            }
            if (i18 == 0) {
                i18 = readBlock();
                if (i18 <= 0) {
                    this.status = 3;
                    break;
                }
                i16 = 0;
            }
            int i20 = i17 + ((bArr4[i16] & 255) << i19);
            int i21 = i16 + 1;
            int i22 = i18 - 1;
            int i23 = i13;
            int i24 = i14;
            int i25 = i8;
            int i26 = i9;
            int i27 = i11;
            int i28 = i12;
            int i29 = i20;
            int i30 = i15;
            int i31 = i19 + 8;
            int i32 = i28;
            while (true) {
                if (i31 < i23) {
                    i11 = i27;
                    i13 = i23;
                    i9 = i26;
                    i16 = i21;
                    i8 = i25;
                    i14 = i24;
                    i18 = i22;
                    int i33 = i32;
                    i19 = i31;
                    i15 = i30;
                    i17 = i29;
                    i12 = i33;
                    break;
                }
                int i34 = i29 & i24;
                int i35 = i29 >> i23;
                i31 -= i23;
                if (i34 == i2) {
                    i23 = readByte + 1;
                    i24 = (1 << i23) - 1;
                    i30 = i2 + 2;
                    i29 = i35;
                    i32 = -1;
                } else if (i34 == i3) {
                    i11 = i27;
                    i12 = i32;
                    i9 = i26;
                    i19 = i31;
                    i8 = i25;
                    i15 = i30;
                    i17 = i35;
                    i14 = i24;
                    i13 = i23;
                    i18 = i22;
                    i16 = i21;
                    break;
                } else if (i32 == -1) {
                    bArr[i26] = bArr2[i34];
                    i29 = i35;
                    i25++;
                    i32 = i34;
                    i26++;
                    i27 = i34;
                } else {
                    if (i34 >= i30) {
                        bArr3[i10] = (byte) i27;
                        i10++;
                        s = i32;
                    } else {
                        s = i34;
                    }
                    while (s >= i2) {
                        bArr3[i10] = bArr2[s];
                        i10++;
                        s = sArr[s];
                    }
                    int i36 = bArr2[s] & 255;
                    bArr[i26] = (byte) i36;
                    int i37 = i26 + 1;
                    int i38 = i25 + 1;
                    while (i10 > 0) {
                        i10--;
                        bArr[i37] = bArr3[i10];
                        i37++;
                        i38++;
                    }
                    if (i30 < 4096) {
                        sArr[i30] = (short) i32;
                        bArr2[i30] = (byte) i36;
                        i30++;
                        if ((i30 & i24) == 0 && i30 < 4096) {
                            i23++;
                            i24 += i30;
                        }
                    }
                    i25 = i38;
                    i32 = i34;
                    i26 = i37;
                    i27 = i36;
                    i29 = i35;
                }
            }
        }
        Arrays.fill(bArr, i9, i, (byte) 0);
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
