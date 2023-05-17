package com.bumptech.glide.gifdecoder;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
/* loaded from: classes8.dex */
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
        if (this.header.status != 0) {
            return true;
        }
        return false;
    }

    private int read() {
        try {
            return this.rawData.get() & 255;
        } catch (Exception unused) {
            this.header.status = 1;
            return 0;
        }
    }

    private void readContents() {
        readContents(Integer.MAX_VALUE);
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
        if (this.header.frameCount > 1) {
            return true;
        }
        return false;
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

    private void readBitmap() {
        boolean z;
        this.header.currentFrame.ix = readShort();
        this.header.currentFrame.iy = readShort();
        this.header.currentFrame.iw = readShort();
        this.header.currentFrame.ih = readShort();
        int read = read();
        boolean z2 = false;
        if ((read & 128) != 0) {
            z = true;
        } else {
            z = false;
        }
        int pow = (int) Math.pow(2.0d, (read & 7) + 1);
        GifFrame gifFrame = this.header.currentFrame;
        if ((read & 64) != 0) {
            z2 = true;
        }
        gifFrame.interlace = z2;
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
            int i = 0;
            int i2 = 0;
            while (i < this.blockSize) {
                try {
                    i2 = this.blockSize - i;
                    this.rawData.get(this.block, i, i2);
                    i += i2;
                } catch (Exception e) {
                    if (Log.isLoggable(TAG, 3)) {
                        Log.d(TAG, "Error Reading Block n: " + i + " count: " + i2 + " blockSize: " + this.blockSize, e);
                    }
                    this.header.status = 1;
                    return;
                }
            }
        }
    }

    private void readHeader() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            sb.append((char) read());
        }
        if (!sb.toString().startsWith("GIF")) {
            this.header.status = 1;
            return;
        }
        readLSD();
        if (this.header.gctFlag && !err()) {
            GifHeader gifHeader = this.header;
            gifHeader.gct = readColorTable(gifHeader.gctSize);
            GifHeader gifHeader2 = this.header;
            gifHeader2.bgColor = gifHeader2.gct[gifHeader2.bgIndex];
        }
    }

    @Nullable
    private int[] readColorTable(int i) {
        byte[] bArr = new byte[i * 3];
        int[] iArr = null;
        try {
            this.rawData.get(bArr);
            iArr = new int[256];
            int i2 = 0;
            int i3 = 0;
            while (i2 < i) {
                int i4 = i3 + 1;
                int i5 = i4 + 1;
                int i6 = i5 + 1;
                int i7 = i2 + 1;
                iArr[i2] = ((bArr[i3] & 255) << 16) | (-16777216) | ((bArr[i4] & 255) << 8) | (bArr[i5] & 255);
                i3 = i6;
                i2 = i7;
            }
        } catch (BufferUnderflowException e) {
            if (Log.isLoggable(TAG, 3)) {
                Log.d(TAG, "Format Error Reading Color Table", e);
            }
            this.header.status = 1;
        }
        return iArr;
    }

    private void readContents(int i) {
        boolean z = false;
        while (!z && !err() && this.header.frameCount <= i) {
            int read = read();
            if (read != 33) {
                if (read != 44) {
                    if (read != 59) {
                        this.header.status = 1;
                    } else {
                        z = true;
                    }
                } else {
                    GifHeader gifHeader = this.header;
                    if (gifHeader.currentFrame == null) {
                        gifHeader.currentFrame = new GifFrame();
                    }
                    readBitmap();
                }
            } else {
                int read2 = read();
                if (read2 != 1) {
                    if (read2 != 249) {
                        if (read2 != 254) {
                            if (read2 != 255) {
                                skip();
                            } else {
                                readBlock();
                                StringBuilder sb = new StringBuilder();
                                for (int i2 = 0; i2 < 11; i2++) {
                                    sb.append((char) this.block[i2]);
                                }
                                if (sb.toString().equals("NETSCAPE2.0")) {
                                    readNetscapeExt();
                                } else {
                                    skip();
                                }
                            }
                        } else {
                            skip();
                        }
                    } else {
                        this.header.currentFrame = new GifFrame();
                        readGraphicControlExt();
                    }
                } else {
                    skip();
                }
            }
        }
    }

    private void readGraphicControlExt() {
        read();
        int read = read();
        GifFrame gifFrame = this.header.currentFrame;
        int i = (read & 28) >> 2;
        gifFrame.dispose = i;
        boolean z = true;
        if (i == 0) {
            gifFrame.dispose = 1;
        }
        GifFrame gifFrame2 = this.header.currentFrame;
        if ((read & 1) == 0) {
            z = false;
        }
        gifFrame2.transparency = z;
        int readShort = readShort();
        if (readShort < 2) {
            readShort = 10;
        }
        GifFrame gifFrame3 = this.header.currentFrame;
        gifFrame3.delay = readShort * 10;
        gifFrame3.transIndex = read();
        read();
    }

    private void readLSD() {
        boolean z;
        this.header.width = readShort();
        this.header.height = readShort();
        int read = read();
        GifHeader gifHeader = this.header;
        if ((read & 128) != 0) {
            z = true;
        } else {
            z = false;
        }
        gifHeader.gctFlag = z;
        this.header.gctSize = (int) Math.pow(2.0d, (read & 7) + 1);
        this.header.bgIndex = read();
        this.header.pixelAspect = read();
    }

    public GifHeaderParser setData(@NonNull ByteBuffer byteBuffer) {
        reset();
        ByteBuffer asReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
        this.rawData = asReadOnlyBuffer;
        asReadOnlyBuffer.position(0);
        this.rawData.order(ByteOrder.LITTLE_ENDIAN);
        return this;
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
