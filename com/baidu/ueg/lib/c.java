package com.baidu.ueg.lib;

import java.util.Arrays;
/* loaded from: classes.dex */
class c {
    byte[] buffer;
    int cDP;
    long cDQ;
    int cDR;
    int cDS;
    int cDT;
    boolean eof;
    int pos;

    public String toString() {
        return String.format("%s[buffer=%s, currentLinePos=%s, eof=%s, ibitWorkArea=%s, lbitWorkArea=%s, modulus=%s, pos=%s, readPos=%s]", getClass().getSimpleName(), Arrays.toString(this.buffer), Integer.valueOf(this.cDS), Boolean.valueOf(this.eof), Integer.valueOf(this.cDP), Long.valueOf(this.cDQ), Integer.valueOf(this.cDT), Integer.valueOf(this.pos), Integer.valueOf(this.cDR));
    }
}
