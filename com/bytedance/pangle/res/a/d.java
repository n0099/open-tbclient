package com.bytedance.pangle.res.a;

import java.io.EOFException;
import java.io.InputStream;
/* loaded from: classes8.dex */
public final class d {
    public static <T> T a(T t) {
        if (t != null) {
            return t;
        }
        throw null;
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r5v0 int), (r1v0 int), (r2v0 int)] */
    public static void a(InputStream inputStream, byte[] bArr, int i, int i2) {
        a(inputStream);
        a(bArr);
        int i3 = 0;
        if (i2 >= 0) {
            int i4 = i + i2;
            int length = bArr.length;
            if (i >= 0 && i4 >= i && i4 <= length) {
                while (i3 < i2) {
                    int read = inputStream.read(bArr, i + i3, i2 - i3);
                    if (read == -1) {
                        break;
                    }
                    i3 += read;
                }
                if (i3 == i2) {
                    return;
                }
                throw new EOFException("reached end of stream after reading " + i3 + " bytes; " + i2 + " bytes expected");
            }
            StringBuilder sb = new StringBuilder();
            sb.append(i);
            sb.append(i4);
            sb.append(length);
            throw new IndexOutOfBoundsException(sb.toString());
        }
        throw new IndexOutOfBoundsException(String.format("len (%s) cannot be negative", Integer.valueOf(i2)));
    }
}
