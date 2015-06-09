package com.baidu.ueg.lib;

import java.util.Arrays;
/* loaded from: classes.dex */
class c {
    byte[] buffer;
    int cDQ;
    long cDR;
    int cDS;
    int cDT;
    int cDU;
    boolean eof;
    int pos;

    public String toString() {
        return String.format("%s[buffer=%s, currentLinePos=%s, eof=%s, ibitWorkArea=%s, lbitWorkArea=%s, modulus=%s, pos=%s, readPos=%s]", getClass().getSimpleName(), Arrays.toString(this.buffer), Integer.valueOf(this.cDT), Boolean.valueOf(this.eof), Integer.valueOf(this.cDQ), Long.valueOf(this.cDR), Integer.valueOf(this.cDU), Integer.valueOf(this.pos), Integer.valueOf(this.cDS));
    }
}
