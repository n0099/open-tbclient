package com.bytedance.sdk.a.b;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
/* loaded from: classes6.dex */
public abstract class c implements Closeable {
    public abstract long b();

    public abstract y epn();

    public abstract com.bytedance.sdk.a.a.e epo();

    public final InputStream c() {
        return epo().eot();
    }

    public final String e() throws IOException {
        com.bytedance.sdk.a.a.e epo = epo();
        try {
            return epo.b(com.bytedance.sdk.a.b.a.c.a(epo, epK()));
        } finally {
            com.bytedance.sdk.a.b.a.c.a(epo);
        }
    }

    private Charset epK() {
        y epn = epn();
        return epn != null ? epn.a(com.bytedance.sdk.a.b.a.c.poY) : com.bytedance.sdk.a.b.a.c.poY;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        com.bytedance.sdk.a.b.a.c.a(epo());
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
            public y epn() {
                return y.this;
            }

            @Override // com.bytedance.sdk.a.b.c
            public long b() {
                return j;
            }

            @Override // com.bytedance.sdk.a.b.c
            public com.bytedance.sdk.a.a.e epo() {
                return eVar;
            }
        };
    }
}
