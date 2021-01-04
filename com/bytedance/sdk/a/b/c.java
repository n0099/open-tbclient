package com.bytedance.sdk.a.b;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
/* loaded from: classes4.dex */
public abstract class c implements Closeable {
    public abstract long b();

    public abstract y eqO();

    public abstract com.bytedance.sdk.a.a.e eqP();

    public final InputStream c() {
        return eqP().epU();
    }

    public final String e() throws IOException {
        com.bytedance.sdk.a.a.e eqP = eqP();
        try {
            return eqP.b(com.bytedance.sdk.a.b.a.c.a(eqP, erl()));
        } finally {
            com.bytedance.sdk.a.b.a.c.a(eqP);
        }
    }

    private Charset erl() {
        y eqO = eqO();
        return eqO != null ? eqO.a(com.bytedance.sdk.a.b.a.c.pjm) : com.bytedance.sdk.a.b.a.c.pjm;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        com.bytedance.sdk.a.b.a.c.a(eqP());
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
            public y eqO() {
                return y.this;
            }

            @Override // com.bytedance.sdk.a.b.c
            public long b() {
                return j;
            }

            @Override // com.bytedance.sdk.a.b.c
            public com.bytedance.sdk.a.a.e eqP() {
                return eVar;
            }
        };
    }
}
