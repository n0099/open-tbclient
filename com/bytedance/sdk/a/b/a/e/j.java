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
    private static final Logger pqy = Logger.getLogger(e.class.getName());
    private final boolean d;
    private boolean g;
    private final com.bytedance.sdk.a.a.d pqz;
    private final com.bytedance.sdk.a.a.c pqu = new com.bytedance.sdk.a.a.c();
    final d.b pqA = new d.b(this.pqu);
    private int f = 16384;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(com.bytedance.sdk.a.a.d dVar, boolean z) {
        this.pqz = dVar;
        this.d = z;
    }

    public synchronized void a() throws IOException {
        if (this.g) {
            throw new IOException(LogConfig.TYPE_CLOSED);
        }
        if (this.d) {
            if (pqy.isLoggable(Level.FINE)) {
                pqy.fine(com.bytedance.sdk.a.b.a.c.a(">> CONNECTION %s", e.ppy.e()));
            }
            this.pqz.ah(e.ppy.h());
            this.pqz.flush();
        }
    }

    public synchronized void a(n nVar) throws IOException {
        if (this.g) {
            throw new IOException(LogConfig.TYPE_CLOSED);
        }
        this.f = nVar.d(this.f);
        if (nVar.c() != -1) {
            this.pqA.a(nVar.c());
        }
        a(0, 0, (byte) 4, (byte) 1);
        this.pqz.flush();
    }

    public synchronized void b(int i, int i2, List<c> list) throws IOException {
        if (this.g) {
            throw new IOException(LogConfig.TYPE_CLOSED);
        }
        this.pqA.a(list);
        long b2 = this.pqu.b();
        int min = (int) Math.min(this.f - 4, b2);
        a(i, min + 4, (byte) 5, b2 == ((long) min) ? (byte) 4 : (byte) 0);
        this.pqz.Oy(Integer.MAX_VALUE & i2);
        this.pqz.a(this.pqu, min);
        if (b2 > min) {
            b(i, b2 - min);
        }
    }

    public synchronized void b() throws IOException {
        if (this.g) {
            throw new IOException(LogConfig.TYPE_CLOSED);
        }
        this.pqz.flush();
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
        this.pqz.Oy(bVar.g);
        this.pqz.flush();
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

    void a(int i, byte b2, com.bytedance.sdk.a.a.c cVar, int i2) throws IOException {
        a(i, i2, (byte) 0, b2);
        if (i2 > 0) {
            this.pqz.a(cVar, i2);
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
                    this.pqz.Oz(i);
                    this.pqz.Oy(nVar.b(i2));
                }
                i2++;
            }
            this.pqz.flush();
        }
    }

    public synchronized void b(boolean z, int i, int i2) throws IOException {
        synchronized (this) {
            if (this.g) {
                throw new IOException(LogConfig.TYPE_CLOSED);
            }
            a(0, 8, (byte) 6, z ? (byte) 1 : (byte) 0);
            this.pqz.Oy(i);
            this.pqz.Oy(i2);
            this.pqz.flush();
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
        this.pqz.Oy(i);
        this.pqz.Oy(bVar.g);
        if (bArr.length > 0) {
            this.pqz.ah(bArr);
        }
        this.pqz.flush();
    }

    public synchronized void a(int i, long j) throws IOException {
        if (this.g) {
            throw new IOException(LogConfig.TYPE_CLOSED);
        }
        if (j == 0 || j > 2147483647L) {
            throw e.h("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: %s", Long.valueOf(j));
        }
        a(i, 4, (byte) 8, (byte) 0);
        this.pqz.Oy((int) j);
        this.pqz.flush();
    }

    public void a(int i, int i2, byte b2, byte b3) throws IOException {
        if (pqy.isLoggable(Level.FINE)) {
            pqy.fine(e.a(false, i, i2, b2, b3));
        }
        if (i2 > this.f) {
            throw e.h("FRAME_SIZE_ERROR length > %d: %d", Integer.valueOf(this.f), Integer.valueOf(i2));
        }
        if ((Integer.MIN_VALUE & i) != 0) {
            throw e.h("reserved bit set: %s", Integer.valueOf(i));
        }
        a(this.pqz, i2);
        this.pqz.OA(b2 & 255);
        this.pqz.OA(b3 & 255);
        this.pqz.Oy(Integer.MAX_VALUE & i);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        this.g = true;
        this.pqz.close();
    }

    private static void a(com.bytedance.sdk.a.a.d dVar, int i) throws IOException {
        dVar.OA((i >>> 16) & 255);
        dVar.OA((i >>> 8) & 255);
        dVar.OA(i & 255);
    }

    private void b(int i, long j) throws IOException {
        while (j > 0) {
            int min = (int) Math.min(this.f, j);
            j -= min;
            a(i, min, (byte) 9, j == 0 ? (byte) 4 : (byte) 0);
            this.pqz.a(this.pqu, min);
        }
    }

    void a(boolean z, int i, List<c> list) throws IOException {
        if (this.g) {
            throw new IOException(LogConfig.TYPE_CLOSED);
        }
        this.pqA.a(list);
        long b2 = this.pqu.b();
        int min = (int) Math.min(this.f, b2);
        byte b3 = b2 == ((long) min) ? (byte) 4 : (byte) 0;
        if (z) {
            b3 = (byte) (b3 | 1);
        }
        a(i, min, (byte) 1, b3);
        this.pqz.a(this.pqu, min);
        if (b2 > min) {
            b(i, b2 - min);
        }
    }
}
