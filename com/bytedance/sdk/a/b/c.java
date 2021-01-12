package com.bytedance.sdk.a.b;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
/* loaded from: classes4.dex */
public abstract class c implements Closeable {
    public abstract long b();

    public abstract y emT();

    public abstract com.bytedance.sdk.a.a.e emU();

    public final InputStream c() {
        return emU().elZ();
    }

    public final String e() throws IOException {
        com.bytedance.sdk.a.a.e emU = emU();
        try {
            return emU.b(com.bytedance.sdk.a.b.a.c.a(emU, enr()));
        } finally {
            com.bytedance.sdk.a.b.a.c.a(emU);
        }
    }

    private Charset enr() {
        y emT = emT();
        return emT != null ? emT.a(com.bytedance.sdk.a.b.a.c.peH) : com.bytedance.sdk.a.b.a.c.peH;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        com.bytedance.sdk.a.b.a.c.a(emU());
    }

    public static c a(y yVar, byte[] bArr) {
        return a(yVar, bArr.length, new com.bytedance.sdk.a.a.c().ai(bArr));
    }

    public static c a(final y yVar, final long j, final com.bytedance.sdk.a.a.e eVar) {
        if (eVar == null) {
            throw new NullPointerException("source == null");
        }
        return new c() { // from class: com.bytedance.sdk.a.b.c.1
            @Override // com.bytedance.sdk.a.b.c
            public y emT() {
                return y.this;
            }

            @Override // com.bytedance.sdk.a.b.c
            public long b() {
                return j;
            }

            @Override // com.bytedance.sdk.a.b.c
            public com.bytedance.sdk.a.a.e emU() {
                return eVar;
            }
        };
    }
}
