package com.bytedance.sdk.a.a;

import com.baidu.live.tbadk.log.LogConfig;
import java.io.IOException;
import java.nio.ByteBuffer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class m implements d {
    boolean c;
    public final c pdp = new c();
    public final r pdx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(r rVar) {
        if (rVar == null) {
            throw new NullPointerException("sink == null");
        }
        this.pdx = rVar;
    }

    @Override // com.bytedance.sdk.a.a.d, com.bytedance.sdk.a.a.e
    public c elX() {
        return this.pdp;
    }

    @Override // com.bytedance.sdk.a.a.r
    public void a(c cVar, long j) throws IOException {
        if (this.c) {
            throw new IllegalStateException(LogConfig.TYPE_CLOSED);
        }
        this.pdp.a(cVar, j);
        emg();
    }

    @Override // com.bytedance.sdk.a.a.d
    public d Xy(String str) throws IOException {
        if (this.c) {
            throw new IllegalStateException(LogConfig.TYPE_CLOSED);
        }
        this.pdp.Xy(str);
        return emg();
    }

    @Override // com.bytedance.sdk.a.a.d
    public d ai(byte[] bArr) throws IOException {
        if (this.c) {
            throw new IllegalStateException(LogConfig.TYPE_CLOSED);
        }
        this.pdp.ai(bArr);
        return emg();
    }

    @Override // com.bytedance.sdk.a.a.d
    public d w(byte[] bArr, int i, int i2) throws IOException {
        if (this.c) {
            throw new IllegalStateException(LogConfig.TYPE_CLOSED);
        }
        this.pdp.w(bArr, i, i2);
        return emg();
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer byteBuffer) throws IOException {
        if (this.c) {
            throw new IllegalStateException(LogConfig.TYPE_CLOSED);
        }
        int write = this.pdp.write(byteBuffer);
        emg();
        return write;
    }

    @Override // com.bytedance.sdk.a.a.d
    public d Of(int i) throws IOException {
        if (this.c) {
            throw new IllegalStateException(LogConfig.TYPE_CLOSED);
        }
        this.pdp.Of(i);
        return emg();
    }

    @Override // com.bytedance.sdk.a.a.d
    public d Oe(int i) throws IOException {
        if (this.c) {
            throw new IllegalStateException(LogConfig.TYPE_CLOSED);
        }
        this.pdp.Oe(i);
        return emg();
    }

    @Override // com.bytedance.sdk.a.a.d
    public d Od(int i) throws IOException {
        if (this.c) {
            throw new IllegalStateException(LogConfig.TYPE_CLOSED);
        }
        this.pdp.Od(i);
        return emg();
    }

    @Override // com.bytedance.sdk.a.a.d
    public d il(long j) throws IOException {
        if (this.c) {
            throw new IllegalStateException(LogConfig.TYPE_CLOSED);
        }
        this.pdp.il(j);
        return emg();
    }

    @Override // com.bytedance.sdk.a.a.d
    public d ik(long j) throws IOException {
        if (this.c) {
            throw new IllegalStateException(LogConfig.TYPE_CLOSED);
        }
        this.pdp.ik(j);
        return emg();
    }

    @Override // com.bytedance.sdk.a.a.d
    public d emg() throws IOException {
        if (this.c) {
            throw new IllegalStateException(LogConfig.TYPE_CLOSED);
        }
        long g = this.pdp.g();
        if (g > 0) {
            this.pdx.a(this.pdp, g);
        }
        return this;
    }

    @Override // com.bytedance.sdk.a.a.d, com.bytedance.sdk.a.a.r, java.io.Flushable
    public void flush() throws IOException {
        if (this.c) {
            throw new IllegalStateException(LogConfig.TYPE_CLOSED);
        }
        if (this.pdp.f5840b > 0) {
            this.pdx.a(this.pdp, this.pdp.f5840b);
        }
        this.pdx.flush();
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
                if (this.pdp.f5840b > 0) {
                    this.pdx.a(this.pdp, this.pdp.f5840b);
                }
            } catch (Throwable th2) {
                th = th2;
            }
            try {
                this.pdx.close();
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
    public t elW() {
        return this.pdx.elW();
    }

    public String toString() {
        return "buffer(" + this.pdx + ")";
    }
}
