package com.bumptech.glide.gifdecoder;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
/* loaded from: classes4.dex */
public class GifHeaderParser {
    public static final int DEFAULT_FRAME_DELAY = 10;
    public static final int DESCRIPTOR_MASK_INTERLACE_FLAG = 64;
    public static final int DESCRIPTOR_MASK_LCT_FLAG = 128;
    public static final int DESCRIPTOR_MASK_LCT_SIZE = 7;
    public static final int EXTENSION_INTRODUCER = 33;
    public static final int GCE_DISPOSAL_METHOD_SHIFT = 2;
    public static final int GCE_MASK_DISPOSAL_METHOD = 28;
    public static final int GCE_MASK_TRANSPARENT_COLOR_FLAG = 1;
    public static final int IMAGE_SEPARATOR = 44;
    public static final int LABEL_APPLICATION_EXTENSION = 255;
    public static final int LABEL_COMMENT_EXTENSION = 254;
    public static final int LABEL_GRAPHIC_CONTROL_EXTENSION = 249;
    public static final int LABEL_PLAIN_TEXT_EXTENSION = 1;
    public static final int LSD_MASK_GCT_FLAG = 128;
    public static final int LSD_MASK_GCT_SIZE = 7;
    public static final int MASK_INT_LOWEST_BYTE = 255;
    public static final int MAX_BLOCK_SIZE = 256;
    public static final int MIN_FRAME_DELAY = 2;
    public static final String TAG = "GifHeaderParser";
    public static final int TRAILER = 59;
    public final byte[] block = new byte[256];
    public int blockSize = 0;
    public GifHeader header;
    public ByteBuffer rawData;

    private boolean err() {
        return this.header.status != 0;
    }

    private int read() {
        try {
            return this.rawData.get() & 255;
        } catch (Exception unused) {
            this.header.status = 1;
            return 0;
        }
    }

    private void readBitmap() {
        this.header.currentFrame.ix = readShort();
        this.header.currentFrame.iy = readShort();
        this.header.currentFrame.iw = readShort();
        this.header.currentFrame.ih = readShort();
        int read = read();
        boolean z = (read & 128) != 0;
        int pow = (int) Math.pow(2.0d, (read & 7) + 1);
        this.header.currentFrame.interlace = (read & 64) != 0;
        if (z) {
            this.header.currentFrame.lct = readColorTable(pow);
        } else {
            this.header.currentFrame.lct = null;
        }
        this.header.currentFrame.bufferFrameStart = this.rawData.position();
        skipImageData();
        if (err()) {
            return;
        }
        GifHeader gifHeader = this.header;
        gifHeader.frameCount++;
        gifHeader.frames.add(gifHeader.currentFrame);
    }

    private void readBlock() {
        int read = read();
        this.blockSize = read;
        if (read > 0) {
            int i2 = 0;
            int i3 = 0;
            while (i2 < this.blockSize) {
                try {
                    i3 = this.blockSize - i2;
                    this.rawData.get(this.block, i2, i3);
                    i2 += i3;
                } catch (Exception e2) {
                    if (Log.isLoggable(TAG, 3)) {
                        Log.d(TAG, "Error Reading Block n: " + i2 + " count: " + i3 + " blockSize: " + this.blockSize, e2);
                    }
                    this.header.status = 1;
                    return;
                }
            }
        }
    }

    @Nullable
    private int[] readColorTable(int i2) {
        byte[] bArr = new byte[i2 * 3];
        int[] iArr = null;
        try {
            this.rawData.get(bArr);
            iArr = new int[256];
            int i3 = 0;
            int i4 = 0;
            while (i3 < i2) {
                int i5 = i4 + 1;
                int i6 = i5 + 1;
                int i7 = i6 + 1;
                int i8 = i3 + 1;
                iArr[i3] = ((bArr[i4] & 255) << 16) | (-16777216) | ((bArr[i5] & 255) << 8) | (bArr[i6] & 255);
                i4 = i7;
                i3 = i8;
            }
        } catch (BufferUnderflowException e2) {
            if (Log.isLoggable(TAG, 3)) {
                Log.d(TAG, "Format Error Reading Color Table", e2);
            }
            this.header.status = 1;
        }
        return iArr;
    }

    private void readContents() {
        readContents(Integer.MAX_VALUE);
    }

    private void readGraphicControlExt() {
        read();
        int read = read();
        GifFrame gifFrame = this.header.currentFrame;
        int i2 = (read & 28) >> 2;
        gifFrame.dispose = i2;
        if (i2 == 0) {
            gifFrame.dispose = 1;
        }
        this.header.currentFrame.transparency = (read & 1) != 0;
        int readShort = readShort();
        if (readShort < 2) {
            readShort = 10;
        }
        GifFrame gifFrame2 = this.header.currentFrame;
        gifFrame2.delay = readShort * 10;
        gifFrame2.transIndex = read();
        read();
    }

    private void readHeader() {
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < 6; i2++) {
            sb.append((char) read());
        }
        if (!sb.toString().startsWith("GIF")) {
            this.header.status = 1;
            return;
        }
        readLSD();
        if (!this.header.gctFlag || err()) {
            return;
        }
        GifHeader gifHeader = this.header;
        gifHeader.gct = readColorTable(gifHeader.gctSize);
        GifHeader gifHeader2 = this.header;
        gifHeader2.bgColor = gifHeader2.gct[gifHeader2.bgIndex];
    }

    private void readLSD() {
        this.header.width = readShort();
        this.header.height = readShort();
        int read = read();
        this.header.gctFlag = (read & 128) != 0;
        this.header.gctSize = (int) Math.pow(2.0d, (read & 7) + 1);
        this.header.bgIndex = read();
        this.header.pixelAspect = read();
    }

    private void readNetscapeExt() {
        do {
            readBlock();
            byte[] bArr = this.block;
            if (bArr[0] == 1) {
                this.header.loopCount = ((bArr[2] & 255) << 8) | (bArr[1] & 255);
            }
            if (this.blockSize <= 0) {
                return;
            }
        } while (!err());
    }

    private int readShort() {
        return this.rawData.getShort();
    }

    private void reset() {
        this.rawData = null;
        Arrays.fill(this.block, (byte) 0);
        this.header = new GifHeader();
        this.blockSize = 0;
    }

    private void skip() {
        int read;
        do {
            read = read();
            this.rawData.position(Math.min(this.rawData.position() + read, this.rawData.limit()));
        } while (read > 0);
    }

    private void skipImageData() {
        read();
        skip();
    }

    public void clear() {
        this.rawData = null;
        this.header = null;
    }

    public boolean isAnimated() {
        readHeader();
        if (!err()) {
            readContents(2);
        }
        return this.header.frameCount > 1;
    }

    @NonNull
    public GifHeader parseHeader() {
        if (this.rawData != null) {
            if (err()) {
                return this.header;
            }
            readHeader();
            if (!err()) {
                readContents();
                GifHeader gifHeader = this.header;
                if (gifHeader.frameCount < 0) {
                    gifHeader.status = 1;
                }
            }
            return this.header;
        }
        throw new IllegalStateException("You must call setData() before parseHeader()");
    }

    public GifHeaderParser setData(@NonNull ByteBuffer byteBuffer) {
        reset();
        ByteBuffer asReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
        this.rawData = asReadOnlyBuffer;
        asReadOnlyBuffer.position(0);
        this.rawData.order(ByteOrder.LITTLE_ENDIAN);
        return this;
    }

    private void readContents(int i2) {
        boolean z = false;
        while (!z && !err() && this.header.frameCount <= i2) {
            int read = read();
            if (read == 33) {
                int read2 = read();
                if (read2 == 1) {
                    skip();
                } else if (read2 == 249) {
                    this.header.currentFrame = new GifFrame();
                    readGraphicControlExt();
                } else if (read2 == 254) {
                    skip();
                } else if (read2 != 255) {
                    skip();
                } else {
                    readBlock();
                    StringBuilder sb = new StringBuilder();
                    for (int i3 = 0; i3 < 11; i3++) {
                        sb.append((char) this.block[i3]);
                    }
                    if (sb.toString().equals("NETSCAPE2.0")) {
                        readNetscapeExt();
                    } else {
                        skip();
                    }
                }
            } else if (read == 44) {
                GifHeader gifHeader = this.header;
                if (gifHeader.currentFrame == null) {
                    gifHeader.currentFrame = new GifFrame();
                }
                readBitmap();
            } else if (read != 59) {
                this.header.status = 1;
            } else {
                z = true;
            }
        }
    }

    public GifHeaderParser setData(@Nullable byte[] bArr) {
        if (bArr != null) {
            setData(ByteBuffer.wrap(bArr));
        } else {
            this.rawData = null;
            this.header.status = 2;
        }
        return this;
    }
}
