package com.bytedance.sdk.a.a;

import com.baidu.live.tbadk.log.LogConfig;
import java.io.IOException;
import java.nio.ByteBuffer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public final class m implements d {
    boolean c;
    public final c pqn = new c();
    public final r pqv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(r rVar) {
        if (rVar == null) {
            throw new NullPointerException("sink == null");
        }
        this.pqv = rVar;
    }

    @Override // com.bytedance.sdk.a.a.d, com.bytedance.sdk.a.a.e
    public c eoG() {
        return this.pqn;
    }

    @Override // com.bytedance.sdk.a.a.r
    public void a(c cVar, long j) throws IOException {
        if (this.c) {
            throw new IllegalStateException(LogConfig.TYPE_CLOSED);
        }
        this.pqn.a(cVar, j);
        eoP();
    }

    @Override // com.bytedance.sdk.a.a.d
    public d YT(String str) throws IOException {
        if (this.c) {
            throw new IllegalStateException(LogConfig.TYPE_CLOSED);
        }
        this.pqn.YT(str);
        return eoP();
    }

    @Override // com.bytedance.sdk.a.a.d
    public d aj(byte[] bArr) throws IOException {
        if (this.c) {
            throw new IllegalStateException(LogConfig.TYPE_CLOSED);
        }
        this.pqn.aj(bArr);
        return eoP();
    }

    @Override // com.bytedance.sdk.a.a.d
    public d w(byte[] bArr, int i, int i2) throws IOException {
        if (this.c) {
            throw new IllegalStateException(LogConfig.TYPE_CLOSED);
        }
        this.pqn.w(bArr, i, i2);
        return eoP();
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer byteBuffer) throws IOException {
        if (this.c) {
            throw new IllegalStateException(LogConfig.TYPE_CLOSED);
        }
        int write = this.pqn.write(byteBuffer);
        eoP();
        return write;
    }

    @Override // com.bytedance.sdk.a.a.d
    public d OF(int i) throws IOException {
        if (this.c) {
            throw new IllegalStateException(LogConfig.TYPE_CLOSED);
        }
        this.pqn.OF(i);
        return eoP();
    }

    @Override // com.bytedance.sdk.a.a.d
    public d OE(int i) throws IOException {
        if (this.c) {
            throw new IllegalStateException(LogConfig.TYPE_CLOSED);
        }
        this.pqn.OE(i);
        return eoP();
    }

    @Override // com.bytedance.sdk.a.a.d
    public d OD(int i) throws IOException {
        if (this.c) {
            throw new IllegalStateException(LogConfig.TYPE_CLOSED);
        }
        this.pqn.OD(i);
        return eoP();
    }

    @Override // com.bytedance.sdk.a.a.d
    public d io(long j) throws IOException {
        if (this.c) {
            throw new IllegalStateException(LogConfig.TYPE_CLOSED);
        }
        this.pqn.io(j);
        return eoP();
    }

    @Override // com.bytedance.sdk.a.a.d
    public d in(long j) throws IOException {
        if (this.c) {
            throw new IllegalStateException(LogConfig.TYPE_CLOSED);
        }
        this.pqn.in(j);
        return eoP();
    }

    @Override // com.bytedance.sdk.a.a.d
    public d eoP() throws IOException {
        if (this.c) {
            throw new IllegalStateException(LogConfig.TYPE_CLOSED);
        }
        long g = this.pqn.g();
        if (g > 0) {
            this.pqv.a(this.pqn, g);
        }
        return this;
    }

    @Override // com.bytedance.sdk.a.a.d, com.bytedance.sdk.a.a.r, java.io.Flushable
    public void flush() throws IOException {
        if (this.c) {
            throw new IllegalStateException(LogConfig.TYPE_CLOSED);
        }
        if (this.pqn.b > 0) {
            this.pqv.a(this.pqn, this.pqn.b);
        }
        this.pqv.flush();
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
                if (this.pqn.b > 0) {
                    this.pqv.a(this.pqn, this.pqn.b);
                }
            } catch (Throwable th2) {
                th = th2;
            }
            try {
                this.pqv.close();
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
    public t eoF() {
        return this.pqv.eoF();
    }

    public String toString() {
        return "buffer(" + this.pqv + ")";
    }
}
