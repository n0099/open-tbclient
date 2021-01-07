package com.bytedance.sdk.a.a;

import com.baidu.live.tbadk.log.LogConfig;
import java.io.IOException;
import java.nio.ByteBuffer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class m implements d {
    boolean c;
    public final c phR = new c();
    public final r phZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(r rVar) {
        if (rVar == null) {
            throw new NullPointerException("sink == null");
        }
        this.phZ = rVar;
    }

    @Override // com.bytedance.sdk.a.a.d, com.bytedance.sdk.a.a.e
    public c epT() {
        return this.phR;
    }

    @Override // com.bytedance.sdk.a.a.r
    public void a(c cVar, long j) throws IOException {
        if (this.c) {
            throw new IllegalStateException(LogConfig.TYPE_CLOSED);
        }
        this.phR.a(cVar, j);
        eqc();
    }

    @Override // com.bytedance.sdk.a.a.d
    public d YG(String str) throws IOException {
        if (this.c) {
            throw new IllegalStateException(LogConfig.TYPE_CLOSED);
        }
        this.phR.YG(str);
        return eqc();
    }

    @Override // com.bytedance.sdk.a.a.d
    public d aj(byte[] bArr) throws IOException {
        if (this.c) {
            throw new IllegalStateException(LogConfig.TYPE_CLOSED);
        }
        this.phR.aj(bArr);
        return eqc();
    }

    @Override // com.bytedance.sdk.a.a.d
    public d x(byte[] bArr, int i, int i2) throws IOException {
        if (this.c) {
            throw new IllegalStateException(LogConfig.TYPE_CLOSED);
        }
        this.phR.x(bArr, i, i2);
        return eqc();
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer byteBuffer) throws IOException {
        if (this.c) {
            throw new IllegalStateException(LogConfig.TYPE_CLOSED);
        }
        int write = this.phR.write(byteBuffer);
        eqc();
        return write;
    }

    @Override // com.bytedance.sdk.a.a.d
    public d PM(int i) throws IOException {
        if (this.c) {
            throw new IllegalStateException(LogConfig.TYPE_CLOSED);
        }
        this.phR.PM(i);
        return eqc();
    }

    @Override // com.bytedance.sdk.a.a.d
    public d PL(int i) throws IOException {
        if (this.c) {
            throw new IllegalStateException(LogConfig.TYPE_CLOSED);
        }
        this.phR.PL(i);
        return eqc();
    }

    @Override // com.bytedance.sdk.a.a.d
    public d PK(int i) throws IOException {
        if (this.c) {
            throw new IllegalStateException(LogConfig.TYPE_CLOSED);
        }
        this.phR.PK(i);
        return eqc();
    }

    @Override // com.bytedance.sdk.a.a.d
    public d il(long j) throws IOException {
        if (this.c) {
            throw new IllegalStateException(LogConfig.TYPE_CLOSED);
        }
        this.phR.il(j);
        return eqc();
    }

    @Override // com.bytedance.sdk.a.a.d
    public d ik(long j) throws IOException {
        if (this.c) {
            throw new IllegalStateException(LogConfig.TYPE_CLOSED);
        }
        this.phR.ik(j);
        return eqc();
    }

    @Override // com.bytedance.sdk.a.a.d
    public d eqc() throws IOException {
        if (this.c) {
            throw new IllegalStateException(LogConfig.TYPE_CLOSED);
        }
        long g = this.phR.g();
        if (g > 0) {
            this.phZ.a(this.phR, g);
        }
        return this;
    }

    @Override // com.bytedance.sdk.a.a.d, com.bytedance.sdk.a.a.r, java.io.Flushable
    public void flush() throws IOException {
        if (this.c) {
            throw new IllegalStateException(LogConfig.TYPE_CLOSED);
        }
        if (this.phR.f6140b > 0) {
            this.phZ.a(this.phR, this.phR.f6140b);
        }
        this.phZ.flush();
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
                if (this.phR.f6140b > 0) {
                    this.phZ.a(this.phR, this.phR.f6140b);
                }
            } catch (Throwable th2) {
                th = th2;
            }
            try {
                this.phZ.close();
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
    public t epS() {
        return this.phZ.epS();
    }

    public String toString() {
        return "buffer(" + this.phZ + ")";
    }
}
