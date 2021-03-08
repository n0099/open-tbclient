package com.bytedance.sdk.a.b.a.e;

import com.baidu.live.tbadk.log.LogConfig;
import com.bytedance.sdk.a.b.a.e.d;
import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/* loaded from: classes6.dex */
final class j implements Closeable {
    private static final Logger ptd = Logger.getLogger(e.class.getName());
    private final boolean d;
    private boolean g;
    private final com.bytedance.sdk.a.a.d pte;
    private final com.bytedance.sdk.a.a.c psZ = new com.bytedance.sdk.a.a.c();
    final d.b ptf = new d.b(this.psZ);
    private int f = 16384;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(com.bytedance.sdk.a.a.d dVar, boolean z) {
        this.pte = dVar;
        this.d = z;
    }

    public synchronized void a() throws IOException {
        if (this.g) {
            throw new IOException(LogConfig.TYPE_CLOSED);
        }
        if (this.d) {
            if (ptd.isLoggable(Level.FINE)) {
                ptd.fine(com.bytedance.sdk.a.b.a.c.a(">> CONNECTION %s", e.psd.e()));
            }
            this.pte.aj(e.psd.h());
            this.pte.flush();
        }
    }

    public synchronized void a(n nVar) throws IOException {
        if (this.g) {
            throw new IOException(LogConfig.TYPE_CLOSED);
        }
        this.f = nVar.d(this.f);
        if (nVar.c() != -1) {
            this.ptf.a(nVar.c());
        }
        a(0, 0, (byte) 4, (byte) 1);
        this.pte.flush();
    }

    public synchronized void b(int i, int i2, List<c> list) throws IOException {
        if (this.g) {
            throw new IOException(LogConfig.TYPE_CLOSED);
        }
        this.ptf.a(list);
        long b = this.psZ.b();
        int min = (int) Math.min(this.f - 4, b);
        a(i, min + 4, (byte) 5, b == ((long) min) ? (byte) 4 : (byte) 0);
        this.pte.OD(Integer.MAX_VALUE & i2);
        this.pte.a(this.psZ, min);
        if (b > min) {
            b(i, b - min);
        }
    }

    public synchronized void b() throws IOException {
        if (this.g) {
            throw new IOException(LogConfig.TYPE_CLOSED);
        }
        this.pte.flush();
    }

    public synchronized void a(boolean z, int i, int i2, List<c> list) throws IOException {
        if (this.g) {
            throw new IOException(LogConfig.TYPE_CLOSED);
        }
        a(z, i, list);
    }

    public synchronized void a(int i, b bVar) throws IOException {
        if (this.g) {
            throw new IOException(LogConfig.TYPE_CLOSED);
        }
        if (bVar.g == -1) {
            throw new IllegalArgumentException();
        }
        a(i, 4, (byte) 3, (byte) 0);
        this.pte.OD(bVar.g);
        this.pte.flush();
    }

    public int c() {
        return this.f;
    }

    public synchronized void a(boolean z, int i, com.bytedance.sdk.a.a.c cVar, int i2) throws IOException {
        if (this.g) {
            throw new IOException(LogConfig.TYPE_CLOSED);
        }
        a(i, z ? (byte) 1 : (byte) 0, cVar, i2);
    }

    void a(int i, byte b, com.bytedance.sdk.a.a.c cVar, int i2) throws IOException {
        a(i, i2, (byte) 0, b);
        if (i2 > 0) {
            this.pte.a(cVar, i2);
        }
    }

    public synchronized void b(n nVar) throws IOException {
        int i;
        int i2 = 0;
        synchronized (this) {
            if (this.g) {
                throw new IOException(LogConfig.TYPE_CLOSED);
            }
            a(0, nVar.b() * 6, (byte) 4, (byte) 0);
            while (i2 < 10) {
                if (nVar.a(i2)) {
                    if (i2 == 4) {
                        i = 3;
                    } else {
                        i = i2 == 7 ? 4 : i2;
                    }
                    this.pte.OE(i);
                    this.pte.OD(nVar.b(i2));
                }
                i2++;
            }
            this.pte.flush();
        }
    }

    public synchronized void b(boolean z, int i, int i2) throws IOException {
        synchronized (this) {
            if (this.g) {
                throw new IOException(LogConfig.TYPE_CLOSED);
            }
            a(0, 8, (byte) 6, z ? (byte) 1 : (byte) 0);
            this.pte.OD(i);
            this.pte.OD(i2);
            this.pte.flush();
        }
    }

    public synchronized void a(int i, b bVar, byte[] bArr) throws IOException {
        if (this.g) {
            throw new IOException(LogConfig.TYPE_CLOSED);
        }
        if (bVar.g == -1) {
            throw e.h("errorCode.httpCode == -1", new Object[0]);
        }
        a(0, bArr.length + 8, (byte) 7, (byte) 0);
        this.pte.OD(i);
        this.pte.OD(bVar.g);
        if (bArr.length > 0) {
            this.pte.aj(bArr);
        }
        this.pte.flush();
    }

    public synchronized void a(int i, long j) throws IOException {
        if (this.g) {
            throw new IOException(LogConfig.TYPE_CLOSED);
        }
        if (j == 0 || j > 2147483647L) {
            throw e.h("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: %s", Long.valueOf(j));
        }
        a(i, 4, (byte) 8, (byte) 0);
        this.pte.OD((int) j);
        this.pte.flush();
    }

    public void a(int i, int i2, byte b, byte b2) throws IOException {
        if (ptd.isLoggable(Level.FINE)) {
            ptd.fine(e.a(false, i, i2, b, b2));
        }
        if (i2 > this.f) {
            throw e.h("FRAME_SIZE_ERROR length > %d: %d", Integer.valueOf(this.f), Integer.valueOf(i2));
        }
        if ((Integer.MIN_VALUE & i) != 0) {
            throw e.h("reserved bit set: %s", Integer.valueOf(i));
        }
        a(this.pte, i2);
        this.pte.OF(b & 255);
        this.pte.OF(b2 & 255);
        this.pte.OD(Integer.MAX_VALUE & i);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        this.g = true;
        this.pte.close();
    }

    private static void a(com.bytedance.sdk.a.a.d dVar, int i) throws IOException {
        dVar.OF((i >>> 16) & 255);
        dVar.OF((i >>> 8) & 255);
        dVar.OF(i & 255);
    }

    private void b(int i, long j) throws IOException {
        while (j > 0) {
            int min = (int) Math.min(this.f, j);
            j -= min;
            a(i, min, (byte) 9, j == 0 ? (byte) 4 : (byte) 0);
            this.pte.a(this.psZ, min);
        }
    }

    void a(boolean z, int i, List<c> list) throws IOException {
        if (this.g) {
            throw new IOException(LogConfig.TYPE_CLOSED);
        }
        this.ptf.a(list);
        long b = this.psZ.b();
        int min = (int) Math.min(this.f, b);
        byte b2 = b == ((long) min) ? (byte) 4 : (byte) 0;
        if (z) {
            b2 = (byte) (b2 | 1);
        }
        a(i, min, (byte) 1, b2);
        this.pte.a(this.psZ, min);
        if (b > min) {
            b(i, b - min);
        }
    }
}
