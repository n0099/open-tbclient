package com.bytedance.sdk.a.a;

import com.baidu.live.tbadk.log.LogConfig;
import java.io.IOException;
import java.nio.ByteBuffer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public final class m implements d {
    boolean c;
    public final c pod = new c();
    public final r pom;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(r rVar) {
        if (rVar == null) {
            throw new NullPointerException("sink == null");
        }
        this.pom = rVar;
    }

    @Override // com.bytedance.sdk.a.a.d, com.bytedance.sdk.a.a.e
    public c eoz() {
        return this.pod;
    }

    @Override // com.bytedance.sdk.a.a.r
    public void a(c cVar, long j) throws IOException {
        if (this.c) {
            throw new IllegalStateException(LogConfig.TYPE_CLOSED);
        }
        this.pod.a(cVar, j);
        eoI();
    }

    @Override // com.bytedance.sdk.a.a.d
    public d YM(String str) throws IOException {
        if (this.c) {
            throw new IllegalStateException(LogConfig.TYPE_CLOSED);
        }
        this.pod.YM(str);
        return eoI();
    }

    @Override // com.bytedance.sdk.a.a.d
    public d ah(byte[] bArr) throws IOException {
        if (this.c) {
            throw new IllegalStateException(LogConfig.TYPE_CLOSED);
        }
        this.pod.ah(bArr);
        return eoI();
    }

    @Override // com.bytedance.sdk.a.a.d
    public d w(byte[] bArr, int i, int i2) throws IOException {
        if (this.c) {
            throw new IllegalStateException(LogConfig.TYPE_CLOSED);
        }
        this.pod.w(bArr, i, i2);
        return eoI();
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer byteBuffer) throws IOException {
        if (this.c) {
            throw new IllegalStateException(LogConfig.TYPE_CLOSED);
        }
        int write = this.pod.write(byteBuffer);
        eoI();
        return write;
    }

    @Override // com.bytedance.sdk.a.a.d
    public d OB(int i) throws IOException {
        if (this.c) {
            throw new IllegalStateException(LogConfig.TYPE_CLOSED);
        }
        this.pod.OB(i);
        return eoI();
    }

    @Override // com.bytedance.sdk.a.a.d
    public d OA(int i) throws IOException {
        if (this.c) {
            throw new IllegalStateException(LogConfig.TYPE_CLOSED);
        }
        this.pod.OA(i);
        return eoI();
    }

    @Override // com.bytedance.sdk.a.a.d
    public d Oz(int i) throws IOException {
        if (this.c) {
            throw new IllegalStateException(LogConfig.TYPE_CLOSED);
        }
        this.pod.Oz(i);
        return eoI();
    }

    @Override // com.bytedance.sdk.a.a.d
    public d io(long j) throws IOException {
        if (this.c) {
            throw new IllegalStateException(LogConfig.TYPE_CLOSED);
        }
        this.pod.io(j);
        return eoI();
    }

    @Override // com.bytedance.sdk.a.a.d
    public d in(long j) throws IOException {
        if (this.c) {
            throw new IllegalStateException(LogConfig.TYPE_CLOSED);
        }
        this.pod.in(j);
        return eoI();
    }

    @Override // com.bytedance.sdk.a.a.d
    public d eoI() throws IOException {
        if (this.c) {
            throw new IllegalStateException(LogConfig.TYPE_CLOSED);
        }
        long g = this.pod.g();
        if (g > 0) {
            this.pom.a(this.pod, g);
        }
        return this;
    }

    @Override // com.bytedance.sdk.a.a.d, com.bytedance.sdk.a.a.r, java.io.Flushable
    public void flush() throws IOException {
        if (this.c) {
            throw new IllegalStateException(LogConfig.TYPE_CLOSED);
        }
        if (this.pod.f5842b > 0) {
            this.pom.a(this.pod, this.pod.f5842b);
        }
        this.pom.flush();
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
                if (this.pod.f5842b > 0) {
                    this.pom.a(this.pod, this.pod.f5842b);
                }
            } catch (Throwable th2) {
                th = th2;
            }
            try {
                this.pom.close();
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
    public t eoy() {
        return this.pom.eoy();
    }

    public String toString() {
        return "buffer(" + this.pom + ")";
    }
}
