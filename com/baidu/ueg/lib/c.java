package com.baidu.ueg.lib;

import java.util.Arrays;
/* loaded from: classes.dex */
class c {
    byte[] buffer;
    int czA;
    int czB;
    int czx;
    long czy;
    int czz;
    boolean eof;
    int pos;

    public String toString() {
        return String.format("%s[buffer=%s, currentLinePos=%s, eof=%s, ibitWorkArea=%s, lbitWorkArea=%s, modulus=%s, pos=%s, readPos=%s]", getClass().getSimpleName(), Arrays.toString(this.buffer), Integer.valueOf(this.czA), Boolean.valueOf(this.eof), Integer.valueOf(this.czx), Long.valueOf(this.czy), Integer.valueOf(this.czB), Integer.valueOf(this.pos), Integer.valueOf(this.czz));
    }
}
