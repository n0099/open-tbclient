package com.bytedance.pangle.e.a;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes7.dex */
public final class b {
    public InputStream a;
    public int b;

    public b(InputStream inputStream) {
        a(inputStream);
    }

    public final void a(InputStream inputStream) {
        this.a = inputStream;
        this.b = 0;
    }

    public final void b(int i) {
        int a = a();
        if (a == i) {
            return;
        }
        throw new IOException(String.format("Expected: 0x%08x got: 0x%08x", Integer.valueOf(i), Integer.valueOf(a)));
    }

    public final int a() {
        int i = 0;
        for (int i2 = 0; i2 != 32; i2 += 8) {
            int read = this.a.read();
            if (read != -1) {
                this.b++;
                i |= read << i2;
            } else {
                throw new EOFException();
            }
        }
        return i;
    }

    public final void b() {
        long skip = this.a.skip(4L);
        this.b = (int) (this.b + skip);
        if (skip == 4) {
            return;
        }
        throw new EOFException();
    }

    public final int[] a(int i) {
        int[] iArr = new int[i];
        int i2 = 0;
        while (i > 0) {
            iArr[i2] = a();
            i--;
            i2++;
        }
        return iArr;
    }
}
