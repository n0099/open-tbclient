package com.baidu.tieba.view;

import android.graphics.Bitmap;
import com.baidu.tieba.util.TiebaLog;
import java.io.InputStream;
import java.util.Vector;
/* loaded from: classes.dex */
public class GifDecoder {
    public static final int MAX_FRAME_NUM = 200;
    public static final int MAX_MEM_NUM = 8388608;
    public static final int MAX_PIX_NUM = 307200;
    protected static final int MAX_STACK_SIZE = 4096;
    public static final int OUT_OF_MEMORY_ERROR = 3;
    public static final int STATUS_FORMAT_ERROR = 1;
    public static final int STATUS_OK = 0;
    public static final int STATUS_OPEN_ERROR = 2;
    protected int[] act;
    protected int bgColor;
    protected int bgIndex;
    protected int frameCount;
    protected Vector<GifFrame> frames;
    protected int[] gct;
    protected boolean gctFlag;
    protected int gctSize;
    protected int height;
    protected int ih;
    protected Bitmap image;
    protected InputStream in;
    protected boolean interlace;
    protected int iw;
    protected int ix;
    protected int iy;
    protected int lastBgColor;
    protected Bitmap lastBitmap;
    protected int[] lct;
    protected boolean lctFlag;
    protected int lctSize;
    protected int lrh;
    protected int lrw;
    protected int lrx;
    protected int lry;
    protected int pixelAspect;
    protected byte[] pixelStack;
    protected byte[] pixels;
    protected short[] prefix;
    protected int status;
    protected byte[] suffix;
    protected int transIndex;
    protected int width;
    protected int loopCount = 1;
    protected byte[] block = new byte[256];
    protected int blockSize = 0;
    protected int dispose = 0;
    protected int lastDispose = 0;
    protected boolean transparency = false;
    protected int delay = 0;
    protected int memstate = 0;
    private boolean interrupted = false;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class GifFrame {
        public int delay;
        public Bitmap image;

        public GifFrame(Bitmap im, int del) {
            this.image = im;
            this.delay = del;
        }
    }

    public int getDelay(int n) {
        this.delay = -1;
        if (n >= 0 && n < this.frameCount) {
            this.delay = this.frames.elementAt(n).delay;
        }
        return this.delay;
    }

    public int getFrameCount() {
        return this.frameCount;
    }

    public Bitmap getBitmap() {
        return getFrame(0);
    }

    public int getLoopCount() {
        return this.loopCount;
    }

    protected void setPixels() {
        int[] dest = new int[this.width * this.height];
        if (this.lastDispose > 0) {
            if (this.lastDispose == 3) {
                int n = this.frameCount - 2;
                if (n > 0) {
                    this.lastBitmap = getFrame(n - 1);
                } else {
                    this.lastBitmap = null;
                }
            }
            if (this.lastBitmap != null) {
                this.lastBitmap.getPixels(dest, 0, this.width, 0, 0, this.width, this.height);
                if (this.lastDispose == 2) {
                    int c = 0;
                    if (!this.transparency) {
                        c = this.lastBgColor;
                    }
                    for (int i = 0; i < this.lrh; i++) {
                        int n1 = ((this.lry + i) * this.width) + this.lrx;
                        int n2 = n1 + this.lrw;
                        for (int k = n1; k < n2; k++) {
                            dest[k] = c;
                        }
                    }
                }
            }
        }
        int pass = 1;
        int inc = 8;
        int iline = 0;
        for (int i2 = 0; i2 < this.ih; i2++) {
            int line = i2;
            if (this.interlace) {
                if (iline >= this.ih) {
                    pass++;
                    switch (pass) {
                        case 2:
                            iline = 4;
                            break;
                        case 3:
                            iline = 2;
                            inc = 4;
                            break;
                        case 4:
                            iline = 1;
                            inc = 2;
                            break;
                    }
                }
                line = iline;
                iline += inc;
            }
            int line2 = line + this.iy;
            if (line2 < this.height) {
                int k2 = line2 * this.width;
                int dx = k2 + this.ix;
                int dlim = dx + this.iw;
                if (this.width + k2 < dlim) {
                    dlim = k2 + this.width;
                }
                int sx = i2 * this.iw;
                int sx2 = sx;
                while (dx < dlim) {
                    int sx3 = sx2 + 1;
                    int index = this.pixels[sx2] & 255;
                    int c2 = this.act[index];
                    if (c2 != 0) {
                        dest[dx] = c2;
                    }
                    dx++;
                    sx2 = sx3;
                }
            }
        }
        this.image = Bitmap.createBitmap(dest, this.width, this.height, Bitmap.Config.ARGB_4444);
    }

    public Bitmap getFrame(int n) {
        if (this.frameCount <= 0) {
            return null;
        }
        return this.frames.elementAt(n % this.frameCount).image;
    }

    public int read(InputStream is) {
        init();
        if (is != null) {
            this.in = is;
            readHeader();
            if (!err()) {
                readContents();
                TiebaLog.i(getClass().getName(), "read", "gif mem ==" + String.valueOf(this.memstate / 1024.0f) + "k");
                if (this.memstate >= 8388608) {
                    return 3;
                }
                if (this.frameCount < 0) {
                    this.status = 1;
                }
            }
        } else {
            this.status = 2;
        }
        try {
            is.close();
        } catch (Exception e) {
        }
        return this.status;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:80:0x0139 */
    /* JADX DEBUG: Multi-variable search result rejected for r6v5, resolved type: short */
    /* JADX WARN: Multi-variable type inference failed */
    protected void decodeBitmapData() {
        int top;
        int npix = this.iw * this.ih;
        if (this.pixels == null || this.pixels.length < npix) {
            this.pixels = new byte[npix];
        }
        if (this.prefix == null) {
            this.prefix = new short[MAX_STACK_SIZE];
        }
        if (this.suffix == null) {
            this.suffix = new byte[MAX_STACK_SIZE];
        }
        if (this.pixelStack == null) {
            this.pixelStack = new byte[4097];
        }
        int data_size = read();
        int clear = 1 << data_size;
        int end_of_information = clear + 1;
        int available = clear + 2;
        int old_code = -1;
        int code_size = data_size + 1;
        int code_mask = (1 << code_size) - 1;
        for (int code = 0; code < clear; code++) {
            this.prefix[code] = 0;
            this.suffix[code] = (byte) code;
        }
        int bi = 0;
        int first = 0;
        int count = 0;
        int bits = 0;
        int datum = 0;
        int i = 0;
        int pi = 0;
        int top2 = 0;
        while (i < npix) {
            if (top2 != 0) {
                top = top2;
            } else if (bits < code_size) {
                if (count == 0) {
                    count = readBlock();
                    if (count <= 0) {
                        break;
                    }
                    bi = 0;
                }
                datum += (this.block[bi] & 255) << bits;
                bits += 8;
                bi++;
                count--;
            } else {
                short code2 = datum & code_mask;
                datum >>= code_size;
                bits -= code_size;
                if (code2 > available) {
                    break;
                } else if (code2 == end_of_information) {
                    break;
                } else if (code2 != clear) {
                    if (old_code == -1) {
                        this.pixelStack[top2] = this.suffix[code2];
                        old_code = code2;
                        first = code2;
                        top2++;
                    } else {
                        if (code2 == available) {
                            this.pixelStack[top2] = (byte) first;
                            code2 = old_code;
                            top2++;
                        }
                        while (code2 > clear) {
                            this.pixelStack[top2] = this.suffix[code2];
                            code2 = this.prefix[code2];
                            top2++;
                        }
                        first = this.suffix[code2] & 255;
                        if (available >= MAX_STACK_SIZE) {
                            break;
                        }
                        top = top2 + 1;
                        this.pixelStack[top2] = (byte) first;
                        this.prefix[available] = (short) old_code;
                        this.suffix[available] = (byte) first;
                        available++;
                        if ((available & code_mask) == 0 && available < MAX_STACK_SIZE) {
                            code_size++;
                            code_mask += available;
                        }
                        old_code = code2;
                    }
                } else {
                    code_size = data_size + 1;
                    code_mask = (1 << code_size) - 1;
                    available = clear + 2;
                    old_code = -1;
                }
            }
            int top3 = top - 1;
            this.pixels[pi] = this.pixelStack[top3];
            i++;
            pi++;
            top2 = top3;
        }
        for (int i2 = pi; i2 < npix; i2++) {
            this.pixels[i2] = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean err() {
        return this.status != 0;
    }

    protected void init() {
        this.status = 0;
        this.frameCount = 0;
        this.frames = new Vector<>();
        this.gct = null;
        this.lct = null;
    }

    protected int read() {
        try {
            int curByte = this.in.read();
            return curByte;
        } catch (Exception e) {
            this.status = 1;
            return 0;
        }
    }

    protected int readBlock() {
        this.blockSize = read();
        int n = 0;
        if (this.blockSize > 0) {
            while (n < this.blockSize) {
                try {
                    int count = this.in.read(this.block, n, this.blockSize - n);
                    if (count == -1) {
                        break;
                    }
                    n += count;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (n < this.blockSize) {
                this.status = 1;
            }
        }
        return n;
    }

    protected int[] readColorTable(int ncolors) {
        int nbytes = ncolors * 3;
        int[] tab = null;
        byte[] c = new byte[nbytes];
        int n = 0;
        try {
            n = this.in.read(c);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (n < nbytes) {
            this.status = 1;
        } else {
            tab = new int[256];
            int j = 0;
            for (int i = 0; i < ncolors; i++) {
                int j2 = j + 1;
                int r = c[j] & 255;
                int j3 = j2 + 1;
                int g = c[j2] & 255;
                int b = c[j3] & 255;
                tab[i] = (-16777216) | (r << 16) | (g << 8) | b;
                j = j3 + 1;
            }
        }
        return tab;
    }

    protected void readContents() {
        boolean done = false;
        while (!done && !err() && !this.interrupted) {
            int code = read();
            if (this.memstate < 8388608) {
                switch (code) {
                    case 33:
                        int code2 = read();
                        switch (code2) {
                            case 1:
                                skip();
                                continue;
                            case 249:
                                readGraphicControlExt();
                                continue;
                            case 254:
                                skip();
                                continue;
                            case 255:
                                readBlock();
                                String app = "";
                                for (int i = 0; i < 11; i++) {
                                    app = String.valueOf(app) + ((char) this.block[i]);
                                }
                                if (app.equals("NETSCAPE2.0")) {
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
                        readBitmap();
                        break;
                    case 59:
                        done = true;
                        break;
                    default:
                        this.status = 1;
                        break;
                }
            } else {
                return;
            }
        }
    }

    protected void readGraphicControlExt() {
        read();
        int packed = read();
        this.dispose = (packed & 28) >> 2;
        if (this.dispose == 0) {
            this.dispose = 1;
        }
        this.transparency = (packed & 1) != 0;
        this.delay = readShort() * 10;
        this.delay = this.delay < 15 ? 100 : this.delay;
        this.transIndex = read();
        read();
    }

    protected void readHeader() {
        String id = "";
        for (int i = 0; i < 6; i++) {
            id = String.valueOf(id) + ((char) read());
        }
        if (!id.startsWith("GIF")) {
            this.status = 1;
            return;
        }
        readLSD();
        if (this.gctFlag && !err()) {
            this.gct = readColorTable(this.gctSize);
            this.bgColor = this.gct[this.bgIndex];
        }
    }

    protected void readBitmap() {
        this.ix = readShort();
        this.iy = readShort();
        this.iw = readShort();
        this.ih = readShort();
        int packed = read();
        this.lctFlag = (packed & 128) != 0;
        this.lctSize = (int) Math.pow(2.0d, (packed & 7) + 1);
        this.interlace = (packed & 64) != 0;
        if (this.lctFlag) {
            this.lct = readColorTable(this.lctSize);
            this.act = this.lct;
        } else {
            this.act = this.gct;
            if (this.bgIndex == this.transIndex) {
                this.bgColor = 0;
            }
        }
        int save = 0;
        if (this.transparency) {
            save = this.act[this.transIndex];
            this.act[this.transIndex] = 0;
        }
        if (this.act == null) {
            this.status = 1;
        }
        if (!err()) {
            decodeBitmapData();
            skip();
            if (!err()) {
                this.frameCount++;
                this.image = Bitmap.createBitmap(this.width, this.height, Bitmap.Config.ARGB_4444);
                setPixels();
                this.frames.addElement(new GifFrame(this.image, this.delay));
                this.memstate += this.width * this.height * 2;
                if (this.transparency) {
                    this.act[this.transIndex] = save;
                }
                resetFrame();
            }
        }
    }

    protected void readLSD() {
        this.width = readShort();
        this.height = readShort();
        int packed = read();
        this.gctFlag = (packed & 128) != 0;
        this.gctSize = 2 << (packed & 7);
        this.bgIndex = read();
        this.pixelAspect = read();
    }

    protected void readNetscapeExt() {
        do {
            readBlock();
            if (this.block[0] == 1) {
                int b1 = this.block[1] & 255;
                int b2 = this.block[2] & 255;
                this.loopCount = (b2 << 8) | b1;
            }
            if (this.blockSize <= 0) {
                return;
            }
        } while (!err());
    }

    protected int readShort() {
        return read() | (read() << 8);
    }

    protected void resetFrame() {
        this.lastDispose = this.dispose;
        this.lrx = this.ix;
        this.lry = this.iy;
        this.lrw = this.iw;
        this.lrh = this.ih;
        this.lastBitmap = this.image;
        this.lastBgColor = this.bgColor;
        this.dispose = 0;
        this.transparency = false;
        this.delay = 0;
        this.lct = null;
    }

    protected void skip() {
        do {
            readBlock();
            if (this.blockSize <= 0) {
                return;
            }
        } while (!err());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void stopDecode() {
        this.interrupted = true;
        if (this.frames != null) {
            for (int i = 0; i < this.frames.size(); i++) {
                this.frames.get(i).image = null;
            }
        }
    }
}
