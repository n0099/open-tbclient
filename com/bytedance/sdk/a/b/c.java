package com.bytedance.sdk.a.b;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
/* loaded from: classes6.dex */
public abstract class c implements Closeable {
    public abstract long b();

    public abstract y epv();

    public abstract com.bytedance.sdk.a.a.e epw();

    public final InputStream c() {
        return epw().eoB();
    }

    public final String e() throws IOException {
        com.bytedance.sdk.a.a.e epw = epw();
        try {
            return epw.b(com.bytedance.sdk.a.b.a.c.a(epw, epS()));
        } finally {
            com.bytedance.sdk.a.b.a.c.a(epw);
        }
    }

    private Charset epS() {
        y epv = epv();
        return epv != null ? epv.a(com.bytedance.sdk.a.b.a.c.ppA) : com.bytedance.sdk.a.b.a.c.ppA;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        com.bytedance.sdk.a.b.a.c.a(epw());
    }

    public static c a(y yVar, byte[] bArr) {
        return a(yVar, bArr.length, new com.bytedance.sdk.a.a.c().ah(bArr));
    }

    public static c a(final y yVar, final long j, final com.bytedance.sdk.a.a.e eVar) {
        if (eVar == null) {
            throw new NullPointerException("source == null");
        }
        return new c() { // from class: com.bytedance.sdk.a.b.c.1
            @Override // com.bytedance.sdk.a.b.c
            public y epv() {
                return y.this;
            }

            @Override // com.bytedance.sdk.a.b.c
            public long b() {
                return j;
            }

            @Override // com.bytedance.sdk.a.b.c
            public com.bytedance.sdk.a.a.e epw() {
                return eVar;
            }
        };
    }
}
