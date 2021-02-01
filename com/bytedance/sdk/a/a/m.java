package com.bytedance.sdk.a.a;

import com.baidu.live.tbadk.log.LogConfig;
import java.io.IOException;
import java.nio.ByteBuffer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public final class m implements d {
    boolean c;
    public final c pnD = new c();
    public final r pnL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(r rVar) {
        if (rVar == null) {
            throw new NullPointerException("sink == null");
        }
        this.pnL = rVar;
    }

    @Override // com.bytedance.sdk.a.a.d, com.bytedance.sdk.a.a.e
    public c eor() {
        return this.pnD;
    }

    @Override // com.bytedance.sdk.a.a.r
    public void a(c cVar, long j) throws IOException {
        if (this.c) {
            throw new IllegalStateException(LogConfig.TYPE_CLOSED);
        }
        this.pnD.a(cVar, j);
        eoA();
    }

    @Override // com.bytedance.sdk.a.a.d
    public d YA(String str) throws IOException {
        if (this.c) {
            throw new IllegalStateException(LogConfig.TYPE_CLOSED);
        }
        this.pnD.YA(str);
        return eoA();
    }

    @Override // com.bytedance.sdk.a.a.d
    public d ah(byte[] bArr) throws IOException {
        if (this.c) {
            throw new IllegalStateException(LogConfig.TYPE_CLOSED);
        }
        this.pnD.ah(bArr);
        return eoA();
    }

    @Override // com.bytedance.sdk.a.a.d
    public d w(byte[] bArr, int i, int i2) throws IOException {
        if (this.c) {
            throw new IllegalStateException(LogConfig.TYPE_CLOSED);
        }
        this.pnD.w(bArr, i, i2);
        return eoA();
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer byteBuffer) throws IOException {
        if (this.c) {
            throw new IllegalStateException(LogConfig.TYPE_CLOSED);
        }
        int write = this.pnD.write(byteBuffer);
        eoA();
        return write;
    }

    @Override // com.bytedance.sdk.a.a.d
    public d OA(int i) throws IOException {
        if (this.c) {
            throw new IllegalStateException(LogConfig.TYPE_CLOSED);
        }
        this.pnD.OA(i);
        return eoA();
    }

    @Override // com.bytedance.sdk.a.a.d
    public d Oz(int i) throws IOException {
        if (this.c) {
            throw new IllegalStateException(LogConfig.TYPE_CLOSED);
        }
        this.pnD.Oz(i);
        return eoA();
    }

    @Override // com.bytedance.sdk.a.a.d
    public d Oy(int i) throws IOException {
        if (this.c) {
            throw new IllegalStateException(LogConfig.TYPE_CLOSED);
        }
        this.pnD.Oy(i);
        return eoA();
    }

    @Override // com.bytedance.sdk.a.a.d
    public d io(long j) throws IOException {
        if (this.c) {
            throw new IllegalStateException(LogConfig.TYPE_CLOSED);
        }
        this.pnD.io(j);
        return eoA();
    }

    @Override // com.bytedance.sdk.a.a.d
    public d in(long j) throws IOException {
        if (this.c) {
            throw new IllegalStateException(LogConfig.TYPE_CLOSED);
        }
        this.pnD.in(j);
        return eoA();
    }

    @Override // com.bytedance.sdk.a.a.d
    public d eoA() throws IOException {
        if (this.c) {
            throw new IllegalStateException(LogConfig.TYPE_CLOSED);
        }
        long g = this.pnD.g();
        if (g > 0) {
            this.pnL.a(this.pnD, g);
        }
        return this;
    }

    @Override // com.bytedance.sdk.a.a.d, com.bytedance.sdk.a.a.r, java.io.Flushable
    public void flush() throws IOException {
        if (this.c) {
            throw new IllegalStateException(LogConfig.TYPE_CLOSED);
        }
        if (this.pnD.f5842b > 0) {
            this.pnL.a(this.pnD, this.pnD.f5842b);
        }
        this.pnL.flush();
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return !this.c;
    }

    @Override // com.bytedance.sdk.a.a.r, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (!this.c) {
            Throwable th = null;
            try {
                if (this.pnD.f5842b > 0) {
                    this.pnL.a(this.pnD, this.pnD.f5842b);
                }
            } catch (Throwable th2) {
                th = th2;
            }
            try {
                this.pnL.close();
            } catch (Throwable th3) {
                if (th == null) {
                    th = th3;
                }
            }
            this.c = true;
            if (th != null) {
                u.a(th);
            }
        }
    }

    @Override // com.bytedance.sdk.a.a.r
    public t eoq() {
        return this.pnL.eoq();
    }

    public String toString() {
        return "buffer(" + this.pnL + ")";
    }
}
