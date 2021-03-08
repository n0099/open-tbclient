package com.bytedance.sdk.a.b;

import java.io.IOException;
import java.nio.charset.Charset;
/* loaded from: classes6.dex */
public abstract class ac {
    public abstract void a(com.bytedance.sdk.a.a.d dVar) throws IOException;

    public abstract y epC();

    public long b() throws IOException {
        return -1L;
    }

    public static ac a(y yVar, String str) {
        Charset charset = com.bytedance.sdk.a.b.a.c.prF;
        if (yVar != null && (charset = yVar.eqq()) == null) {
            charset = com.bytedance.sdk.a.b.a.c.prF;
            yVar = y.Zg(yVar + "; charset=utf-8");
        }
        return b(yVar, str.getBytes(charset));
    }

    public static ac b(y yVar, byte[] bArr) {
        return a(yVar, bArr, 0, bArr.length);
    }

    public static ac a(final y yVar, final byte[] bArr, final int i, final int i2) {
        if (bArr == null) {
            throw new NullPointerException("content == null");
        }
        com.bytedance.sdk.a.b.a.c.a(bArr.length, i, i2);
        return new ac() { // from class: com.bytedance.sdk.a.b.ac.1
            @Override // com.bytedance.sdk.a.b.ac
            public y epC() {
                return y.this;
            }

            @Override // com.bytedance.sdk.a.b.ac
            public long b() {
                return i2;
            }

            @Override // com.bytedance.sdk.a.b.ac
            public void a(com.bytedance.sdk.a.a.d dVar) throws IOException {
                dVar.w(bArr, i, i2);
            }
        };
    }
}
