package com.baidu.ueg.lib;

import java.util.Arrays;
/* loaded from: classes.dex */
class c {
    byte[] buffer;
    int czb;
    long czc;
    int czd;
    int cze;
    int czf;
    boolean eof;
    int pos;

    public String toString() {
        return String.format("%s[buffer=%s, currentLinePos=%s, eof=%s, ibitWorkArea=%s, lbitWorkArea=%s, modulus=%s, pos=%s, readPos=%s]", getClass().getSimpleName(), Arrays.toString(this.buffer), Integer.valueOf(this.cze), Boolean.valueOf(this.eof), Integer.valueOf(this.czb), Long.valueOf(this.czc), Integer.valueOf(this.czf), Integer.valueOf(this.pos), Integer.valueOf(this.czd));
    }
}
