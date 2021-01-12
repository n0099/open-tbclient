package com.bytedance.sdk.a.a;

import com.baidu.live.tbadk.log.LogConfig;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class n implements e {
    boolean c;
    public final c pdp = new c();
    public final s pdy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(s sVar) {
        if (sVar == null) {
            throw new NullPointerException("source == null");
        }
        this.pdy = sVar;
    }

    @Override // com.bytedance.sdk.a.a.e
    public c elX() {
        return this.pdp;
    }

    @Override // com.bytedance.sdk.a.a.s
    public long b(c cVar, long j) throws IOException {
        if (cVar == null) {
            throw new IllegalArgumentException("sink == null");
        }
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        }
        if (this.c) {
            throw new IllegalStateException(LogConfig.TYPE_CLOSED);
        }
        if (this.pdp.f5840b == 0 && this.pdy.b(this.pdp, 8192L) == -1) {
            return -1L;
        }
        return this.pdp.b(cVar, Math.min(j, this.pdp.f5840b));
    }

    @Override // com.bytedance.sdk.a.a.e
    public boolean e() throws IOException {
        if (this.c) {
            throw new IllegalStateException(LogConfig.TYPE_CLOSED);
        }
        return this.pdp.e() && this.pdy.b(this.pdp, 8192L) == -1;
    }

    @Override // com.bytedance.sdk.a.a.e
    public void a(long j) throws IOException {
        if (!b(j)) {
            throw new EOFException();
        }
    }

    public boolean b(long j) throws IOException {
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        }
        if (this.c) {
            throw new IllegalStateException(LogConfig.TYPE_CLOSED);
        }
        while (this.pdp.f5840b < j) {
            if (this.pdy.b(this.pdp, 8192L) == -1) {
                return false;
            }
        }
        return true;
    }

    @Override // com.bytedance.sdk.a.a.e
    public byte ema() throws IOException {
        a(1L);
        return this.pdp.ema();
    }

    @Override // com.bytedance.sdk.a.a.e
    /* renamed from: if */
    public f mo54if(long j) throws IOException {
        a(j);
        return this.pdp.mo54if(j);
    }

    @Override // com.bytedance.sdk.a.a.e
    public byte[] ih(long j) throws IOException {
        a(j);
        return this.pdp.ih(j);
    }

    @Override // com.bytedance.sdk.a.a.e
    public void a(byte[] bArr) throws IOException {
        try {
            a(bArr.length);
            this.pdp.a(bArr);
        } catch (EOFException e) {
            int i = 0;
            while (this.pdp.f5840b > 0) {
                int a2 = this.pdp.a(bArr, i, (int) this.pdp.f5840b);
                if (a2 == -1) {
                    throw new AssertionError();
                }
                i += a2;
            }
            throw e;
        }
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer byteBuffer) throws IOException {
        if (this.pdp.f5840b == 0 && this.pdy.b(this.pdp, 8192L) == -1) {
            return -1;
        }
        return this.pdp.read(byteBuffer);
    }

    @Override // com.bytedance.sdk.a.a.e
    public String b(Charset charset) throws IOException {
        if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        }
        this.pdp.b(this.pdy);
        return this.pdp.b(charset);
    }

    @Override // com.bytedance.sdk.a.a.e
    public String p() throws IOException {
        return e(Long.MAX_VALUE);
    }

    @Override // com.bytedance.sdk.a.a.e
    public String e(long j) throws IOException {
        if (j < 0) {
            throw new IllegalArgumentException("limit < 0: " + j);
        }
        long j2 = j == Long.MAX_VALUE ? Long.MAX_VALUE : j + 1;
        long a2 = a((byte) 10, 0L, j2);
        if (a2 != -1) {
            return this.pdp.ig(a2);
        }
        if (j2 < Long.MAX_VALUE && b(j2) && this.pdp.ie(j2 - 1) == 13 && b(1 + j2) && this.pdp.ie(j2) == 10) {
            return this.pdp.ig(j2);
        }
        c cVar = new c();
        this.pdp.a(cVar, 0L, Math.min(32L, this.pdp.b()));
        throw new EOFException("\\n not found: limit=" + Math.min(this.pdp.b(), j) + " content=" + cVar.emd().e() + (char) 8230);
    }

    @Override // com.bytedance.sdk.a.a.e
    public short emb() throws IOException {
        a(2L);
        return this.pdp.emb();
    }

    @Override // com.bytedance.sdk.a.a.e
    public short emc() throws IOException {
        a(2L);
        return this.pdp.emc();
    }

    @Override // com.bytedance.sdk.a.a.e
    public int j() throws IOException {
        a(4L);
        return this.pdp.j();
    }

    @Override // com.bytedance.sdk.a.a.e
    public int l() throws IOException {
        a(4L);
        return this.pdp.l();
    }

    @Override // com.bytedance.sdk.a.a.e
    public long m() throws IOException {
        a(1L);
        for (int i = 0; b(i + 1); i++) {
            byte ie = this.pdp.ie(i);
            if ((ie < 48 || ie > 57) && ((ie < 97 || ie > 102) && (ie < 65 || ie > 70))) {
                if (i == 0) {
                    throw new NumberFormatException(String.format("Expected leading [0-9a-fA-F] character but was %#x", Byte.valueOf(ie)));
                }
                return this.pdp.m();
            }
        }
        return this.pdp.m();
    }

    @Override // com.bytedance.sdk.a.a.e
    public void h(long j) throws IOException {
        if (this.c) {
            throw new IllegalStateException(LogConfig.TYPE_CLOSED);
        }
        while (j > 0) {
            if (this.pdp.f5840b == 0 && this.pdy.b(this.pdp, 8192L) == -1) {
                throw new EOFException();
            }
            long min = Math.min(j, this.pdp.b());
            this.pdp.h(min);
            j -= min;
        }
    }

    @Override // com.bytedance.sdk.a.a.e
    public long e(byte b2) throws IOException {
        return a(b2, 0L, Long.MAX_VALUE);
    }

    public long a(byte b2, long j, long j2) throws IOException {
        if (this.c) {
            throw new IllegalStateException(LogConfig.TYPE_CLOSED);
        }
        if (j < 0 || j2 < j) {
            throw new IllegalArgumentException(String.format("fromIndex=%s toIndex=%s", Long.valueOf(j), Long.valueOf(j2)));
        }
        long j3 = j;
        while (j3 < j2) {
            long a2 = this.pdp.a(b2, j3, j2);
            if (a2 == -1) {
                long j4 = this.pdp.f5840b;
                if (j4 >= j2 || this.pdy.b(this.pdp, 8192L) == -1) {
                    return -1L;
                }
                j3 = Math.max(j3, j4);
            } else {
                return a2;
            }
        }
        return -1L;
    }

    @Override // com.bytedance.sdk.a.a.e
    public boolean a(long j, f fVar) throws IOException {
        return a(j, fVar, 0, fVar.g());
    }

    public boolean a(long j, f fVar, int i, int i2) throws IOException {
        if (this.c) {
            throw new IllegalStateException(LogConfig.TYPE_CLOSED);
        }
        if (j < 0 || i < 0 || i2 < 0 || fVar.g() - i < i2) {
            return false;
        }
        for (int i3 = 0; i3 < i2; i3++) {
            long j2 = i3 + j;
            if (!b(1 + j2) || this.pdp.ie(j2) != fVar.a(i + i3)) {
                return false;
            }
        }
        return true;
    }

    @Override // com.bytedance.sdk.a.a.e
    public InputStream elZ() {
        return new InputStream() { // from class: com.bytedance.sdk.a.a.n.1
            @Override // java.io.InputStream
            public int read() throws IOException {
                if (n.this.c) {
                    throw new IOException(LogConfig.TYPE_CLOSED);
                }
                if (n.this.pdp.f5840b == 0 && n.this.pdy.b(n.this.pdp, 8192L) == -1) {
                    return -1;
                }
                return n.this.pdp.ema() & 255;
            }

            @Override // java.io.InputStream
            public int read(byte[] bArr, int i, int i2) throws IOException {
                if (n.this.c) {
                    throw new IOException(LogConfig.TYPE_CLOSED);
                }
                u.a(bArr.length, i, i2);
                if (n.this.pdp.f5840b == 0 && n.this.pdy.b(n.this.pdp, 8192L) == -1) {
                    return -1;
                }
                return n.this.pdp.a(bArr, i, i2);
            }

            @Override // java.io.InputStream
            public int available() throws IOException {
                if (n.this.c) {
                    throw new IOException(LogConfig.TYPE_CLOSED);
                }
                return (int) Math.min(n.this.pdp.f5840b, 2147483647L);
            }

            @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                n.this.close();
            }

            public String toString() {
                return n.this + ".inputStream()";
            }
        };
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return !this.c;
    }

    @Override // com.bytedance.sdk.a.a.s, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (!this.c) {
            this.c = true;
            this.pdy.close();
            this.pdp.r();
        }
    }

    @Override // com.bytedance.sdk.a.a.s
    public t elW() {
        return this.pdy.elW();
    }

    public String toString() {
        return "buffer(" + this.pdy + ")";
    }
}
