package com.baidu.zeus.bouncycastle;
/* loaded from: classes.dex */
public class X509NameTokenizer {
    private StringBuffer buf;
    private int index;
    private char seperator;
    private String value;

    public X509NameTokenizer(String str) {
        this(str, ',');
    }

    public X509NameTokenizer(String str, char c) {
        this.buf = new StringBuffer();
        this.value = str;
        this.index = -1;
        this.seperator = c;
    }

    public boolean hasMoreTokens() {
        return this.index != this.value.length();
    }

    public String nextToken() {
        boolean z;
        if (this.index == this.value.length()) {
            return null;
        }
        this.buf.setLength(0);
        boolean z2 = false;
        int i = this.index + 1;
        boolean z3 = false;
        while (i != this.value.length()) {
            char charAt = this.value.charAt(i);
            if (charAt == '\"') {
                if (!z3) {
                    z = !z2;
                } else {
                    this.buf.append(charAt);
                    z = z2;
                }
                z2 = z;
                z3 = false;
            } else if (z3 || z2) {
                if (charAt == '#' && this.buf.charAt(this.buf.length() - 1) == '=') {
                    this.buf.append('\\');
                } else if (charAt == '+' && this.seperator != '+') {
                    this.buf.append('\\');
                }
                this.buf.append(charAt);
                z3 = false;
            } else if (charAt == '\\') {
                z3 = true;
            } else if (charAt == this.seperator) {
                break;
            } else {
                this.buf.append(charAt);
            }
            i++;
        }
        this.index = i;
        return this.buf.toString().trim();
    }
}
