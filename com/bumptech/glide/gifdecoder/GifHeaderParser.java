package com.bumptech.glide.gifdecoder;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.ActivityChooserView;
import androidx.core.view.ViewCompat;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
/* loaded from: classes15.dex */
public class GifHeaderParser {
    static final int DEFAULT_FRAME_DELAY = 10;
    private static final int DESCRIPTOR_MASK_INTERLACE_FLAG = 64;
    private static final int DESCRIPTOR_MASK_LCT_FLAG = 128;
    private static final int DESCRIPTOR_MASK_LCT_SIZE = 7;
    private static final int EXTENSION_INTRODUCER = 33;
    private static final int GCE_DISPOSAL_METHOD_SHIFT = 2;
    private static final int GCE_MASK_DISPOSAL_METHOD = 28;
    private static final int GCE_MASK_TRANSPARENT_COLOR_FLAG = 1;
    private static final int IMAGE_SEPARATOR = 44;
    private static final int LABEL_APPLICATION_EXTENSION = 255;
    private static final int LABEL_COMMENT_EXTENSION = 254;
    private static final int LABEL_GRAPHIC_CONTROL_EXTENSION = 249;
    private static final int LABEL_PLAIN_TEXT_EXTENSION = 1;
    private static final int LSD_MASK_GCT_FLAG = 128;
    private static final int LSD_MASK_GCT_SIZE = 7;
    private static final int MASK_INT_LOWEST_BYTE = 255;
    private static final int MAX_BLOCK_SIZE = 256;
    static final int MIN_FRAME_DELAY = 2;
    private static final String TAG = "GifHeaderParser";
    private static final int TRAILER = 59;
    private final byte[] block = new byte[256];
    private int blockSize = 0;
    private GifHeader header;
    private ByteBuffer rawData;

    public GifHeaderParser setData(@NonNull ByteBuffer byteBuffer) {
        reset();
        this.rawData = byteBuffer.asReadOnlyBuffer();
        this.rawData.position(0);
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

    public void clear() {
        this.rawData = null;
        this.header = null;
    }

    private void reset() {
        this.rawData = null;
        Arrays.fill(this.block, (byte) 0);
        this.header = new GifHeader();
        this.blockSize = 0;
    }

    @NonNull
    public GifHeader parseHeader() {
        if (this.rawData == null) {
            throw new IllegalStateException("You must call setData() before parseHeader()");
        }
        if (err()) {
            return this.header;
        }
        readHeader();
        if (!err()) {
            readContents();
            if (this.header.frameCount < 0) {
                this.header.status = 1;
            }
        }
        return this.header;
    }

    public boolean isAnimated() {
        readHeader();
        if (!err()) {
            readContents(2);
        }
        return this.header.frameCount > 1;
    }

    private void readContents() {
        readContents(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
    }

    private void readContents(int i) {
        boolean z = false;
        while (!z && !err() && this.header.frameCount <= i) {
            switch (read()) {
                case 33:
                    switch (read()) {
                        case 1:
                            skip();
                            continue;
                        case 249:
                            this.header.currentFrame = new GifFrame();
                            readGraphicControlExt();
                            continue;
                        case 254:
                            skip();
                            continue;
                        case 255:
                            readBlock();
                            StringBuilder sb = new StringBuilder();
                            for (int i2 = 0; i2 < 11; i2++) {
                                sb.append((char) this.block[i2]);
                            }
                            if (sb.toString().equals("NETSCAPE2.0")) {
                                readNetscapeExt();
                                break;
                            } else {
                                skip();
                                continue;
                            }
                        default:
                            skip();
                            continue;
                    }
                case 44:
                    if (this.header.currentFrame == null) {
                        this.header.currentFrame = new GifFrame();
                    }
                    readBitmap();
                    break;
                case 59:
                    z = true;
                    break;
                default:
                    this.header.status = 1;
                    break;
            }
        }
    }

    private void readGraphicControlExt() {
        read();
        int read = read();
        this.header.currentFrame.dispose = (read & 28) >> 2;
        if (this.header.currentFrame.dispose == 0) {
            this.header.currentFrame.dispose = 1;
        }
        this.header.currentFrame.transparency = (read & 1) != 0;
        int readShort = readShort();
        if (readShort < 2) {
            readShort = 10;
        }
        this.header.currentFrame.delay = readShort * 10;
        this.header.currentFrame.transIndex = read();
        read();
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
        if (!err()) {
            this.header.frameCount++;
            this.header.frames.add(this.header.currentFrame);
        }
    }

    private void readNetscapeExt() {
        do {
            readBlock();
            if (this.block[0] == 1) {
                this.header.loopCount = (this.block[1] & 255) | ((this.block[2] & 255) << 8);
            }
            if (this.blockSize <= 0) {
                return;
            }
        } while (!err());
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
            this.header.gct = readColorTable(this.header.gctSize);
            this.header.bgColor = this.header.gct[this.header.bgIndex];
        }
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

    @Nullable
    private int[] readColorTable(int i) {
        int[] iArr = null;
        byte[] bArr = new byte[i * 3];
        try {
            this.rawData.get(bArr);
            iArr = new int[256];
            int i2 = 0;
            int i3 = 0;
            while (i3 < i) {
                int i4 = i2 + 1;
                int i5 = bArr[i2] & 255;
                int i6 = i4 + 1;
                int i7 = bArr[i4] & 255;
                i2 = i6 + 1;
                int i8 = i3 + 1;
                iArr[i3] = (i5 << 16) | ViewCompat.MEASURED_STATE_MASK | (i7 << 8) | (bArr[i6] & 255);
                i3 = i8;
            }
        } catch (BufferUnderflowException e) {
            if (Log.isLoggable(TAG, 3)) {
                Log.d(TAG, "Format Error Reading Color Table", e);
            }
            this.header.status = 1;
        }
        return iArr;
    }

    private void skipImageData() {
        read();
        skip();
    }

    private void skip() {
        int read;
        do {
            read = read();
            this.rawData.position(Math.min(this.rawData.position() + read, this.rawData.limit()));
        } while (read > 0);
    }

    private void readBlock() {
        int i;
        int i2 = 0;
        this.blockSize = read();
        if (this.blockSize <= 0) {
            return;
        }
        int i3 = 0;
        while (true) {
            try {
                i = i2;
                if (i < this.blockSize) {
                    i3 = this.blockSize - i;
                    this.rawData.get(this.block, i, i3);
                    i2 = i + i3;
                } else {
                    return;
                }
            } catch (Exception e) {
                if (Log.isLoggable(TAG, 3)) {
                    Log.d(TAG, "Error Reading Block n: " + i + " count: " + i3 + " blockSize: " + this.blockSize, e);
                }
                this.header.status = 1;
                return;
            }
        }
    }

    private int read() {
        try {
            return this.rawData.get() & 255;
        } catch (Exception e) {
            this.header.status = 1;
            return 0;
        }
    }

    private int readShort() {
        return this.rawData.getShort();
    }

    private boolean err() {
        return this.header.status != 0;
    }
}
