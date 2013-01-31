package com.baidu.zeus;

import org.apache.http.protocol.HTTP;
import org.apache.http.util.CharArrayBuffer;
/* loaded from: classes.dex */
class CharArrayBuffers {
    static final char uppercaseAddon = ' ';

    CharArrayBuffers() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean containsIgnoreCaseTrimmed(CharArrayBuffer charArrayBuffer, int i, String str) {
        int length = charArrayBuffer.length();
        char[] buffer = charArrayBuffer.buffer();
        while (i < length && HTTP.isWhitespace(buffer[i])) {
            i++;
        }
        int length2 = str.length();
        boolean z = length >= i + length2;
        for (int i2 = 0; z && i2 < length2; i2++) {
            char c = buffer[i + i2];
            char charAt = str.charAt(i2);
            if (c != charAt) {
                z = toLower(c) == toLower(charAt);
            }
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int setLowercaseIndexOf(CharArrayBuffer charArrayBuffer, int i) {
        int length = charArrayBuffer.length();
        char[] buffer = charArrayBuffer.buffer();
        for (int i2 = 0; i2 < length; i2++) {
            char c = buffer[i2];
            if (c != i) {
                if (c >= 'A' && c <= 'Z') {
                    buffer[i2] = (char) (c + uppercaseAddon);
                }
            } else {
                return i2;
            }
        }
        return -1;
    }

    private static char toLower(char c) {
        if (c >= 'A' && c <= 'Z') {
            return (char) (c + uppercaseAddon);
        }
        return c;
    }
}
