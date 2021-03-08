package com.bytedance.sdk.a.b;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
/* loaded from: classes6.dex */
public abstract class c implements Closeable {
    public abstract long b();

    public abstract y epC();

    public abstract com.bytedance.sdk.a.a.e epD();

    public final InputStream c() {
        return epD().eoI();
    }

    public final String e() throws IOException {
        com.bytedance.sdk.a.a.e epD = epD();
        try {
            return epD.b(com.bytedance.sdk.a.b.a.c.a(epD, epZ()));
        } finally {
            com.bytedance.sdk.a.b.a.c.a(epD);
        }
    }

    private Charset epZ() {
        y epC = epC();
        return epC != null ? epC.a(com.bytedance.sdk.a.b.a.c.prF) : com.bytedance.sdk.a.b.a.c.prF;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        com.bytedance.sdk.a.b.a.c.a(epD());
    }

    public static c a(y yVar, byte[] bArr) {
        return a(yVar, bArr.length, new com.bytedance.sdk.a.a.c().aj(bArr));
    }

    public static c a(final y yVar, final long j, final com.bytedance.sdk.a.a.e eVar) {
        if (eVar == null) {
            throw new NullPointerException("source == null");
        }
        return new c() { // from class: com.bytedance.sdk.a.b.c.1
            @Override // com.bytedance.sdk.a.b.c
            public y epC() {
                return y.this;
            }

            @Override // com.bytedance.sdk.a.b.c
            public long b() {
                return j;
            }

            @Override // com.bytedance.sdk.a.b.c
            public com.bytedance.sdk.a.a.e epD() {
                return eVar;
            }
        };
    }
}
