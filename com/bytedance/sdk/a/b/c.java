package com.bytedance.sdk.a.b;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
/* loaded from: classes4.dex */
public abstract class c implements Closeable {
    public abstract long b();

    public abstract y eqP();

    public abstract com.bytedance.sdk.a.a.e eqQ();

    public final InputStream c() {
        return eqQ().epV();
    }

    public final String e() throws IOException {
        com.bytedance.sdk.a.a.e eqQ = eqQ();
        try {
            return eqQ.b(com.bytedance.sdk.a.b.a.c.a(eqQ, erm()));
        } finally {
            com.bytedance.sdk.a.b.a.c.a(eqQ);
        }
    }

    private Charset erm() {
        y eqP = eqP();
        return eqP != null ? eqP.a(com.bytedance.sdk.a.b.a.c.pjm) : com.bytedance.sdk.a.b.a.c.pjm;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        com.bytedance.sdk.a.b.a.c.a(eqQ());
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
            public y eqP() {
                return y.this;
            }

            @Override // com.bytedance.sdk.a.b.c
            public long b() {
                return j;
            }

            @Override // com.bytedance.sdk.a.b.c
            public com.bytedance.sdk.a.a.e eqQ() {
                return eVar;
            }
        };
    }
}
