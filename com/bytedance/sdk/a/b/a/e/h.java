package com.bytedance.sdk.a.b.a.e;

import com.bytedance.sdk.a.a.s;
import com.bytedance.sdk.a.a.t;
import com.bytedance.sdk.a.b.a.e.d;
import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public final class h implements Closeable {

    /* renamed from: a  reason: collision with root package name */
    static final Logger f3979a = Logger.getLogger(e.class.getName());
    private final boolean e;
    private final com.bytedance.sdk.a.a.e prV;
    private final a psR;
    final d.a psS;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public interface b {
        void a();

        void a(int i, int i2, int i3, boolean z);

        void a(int i, long j);

        void a(int i, com.bytedance.sdk.a.b.a.e.b bVar);

        void a(int i, com.bytedance.sdk.a.b.a.e.b bVar, com.bytedance.sdk.a.a.f fVar);

        void a(boolean z, int i, int i2, List<c> list);

        void a(boolean z, int i, com.bytedance.sdk.a.a.e eVar, int i2) throws IOException;

        void a(boolean z, n nVar);

        void b(int i, int i2, List<c> list) throws IOException;

        void b(boolean z, int i, int i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(com.bytedance.sdk.a.a.e eVar, boolean z) {
        this.prV = eVar;
        this.e = z;
        this.psR = new a(this.prV);
        this.psS = new d.a(4096, this.psR);
    }

    public void a(b bVar) throws IOException {
        if (this.e) {
            if (!a(true, bVar)) {
                throw e.j("Required SETTINGS preface not received", new Object[0]);
            }
            return;
        }
        com.bytedance.sdk.a.a.f ii = this.prV.ii(e.psd.g());
        if (f3979a.isLoggable(Level.FINE)) {
            f3979a.fine(com.bytedance.sdk.a.b.a.c.a("<< CONNECTION %s", ii.e()));
        }
        if (!e.psd.equals(ii)) {
            throw e.j("Expected a connection header but was %s", ii.a());
        }
    }

    public boolean a(boolean z, b bVar) throws IOException {
        try {
            this.prV.a(9L);
            int a2 = a(this.prV);
            if (a2 < 0 || a2 > 16384) {
                throw e.j("FRAME_SIZE_ERROR: %s", Integer.valueOf(a2));
            }
            byte eoJ = (byte) (this.prV.eoJ() & 255);
            if (z && eoJ != 4) {
                throw e.j("Expected a SETTINGS frame but was %s", Byte.valueOf(eoJ));
            }
            byte eoJ2 = (byte) (this.prV.eoJ() & 255);
            int j = this.prV.j() & Integer.MAX_VALUE;
            if (f3979a.isLoggable(Level.FINE)) {
                f3979a.fine(e.a(true, j, a2, eoJ, eoJ2));
            }
            switch (eoJ) {
                case 0:
                    b(bVar, a2, eoJ2, j);
                    return true;
                case 1:
                    a(bVar, a2, eoJ2, j);
                    return true;
                case 2:
                    c(bVar, a2, eoJ2, j);
                    return true;
                case 3:
                    d(bVar, a2, eoJ2, j);
                    return true;
                case 4:
                    e(bVar, a2, eoJ2, j);
                    return true;
                case 5:
                    f(bVar, a2, eoJ2, j);
                    return true;
                case 6:
                    g(bVar, a2, eoJ2, j);
                    return true;
                case 7:
                    h(bVar, a2, eoJ2, j);
                    return true;
                case 8:
                    i(bVar, a2, eoJ2, j);
                    return true;
                default:
                    this.prV.h(a2);
                    return true;
            }
        } catch (IOException e) {
            return false;
        }
    }

    private void a(b bVar, int i, byte b2, int i2) throws IOException {
        if (i2 == 0) {
            throw e.j("PROTOCOL_ERROR: TYPE_HEADERS streamId == 0", new Object[0]);
        }
        boolean z = (b2 & 1) != 0;
        short eoJ = (b2 & 8) != 0 ? (short) (this.prV.eoJ() & 255) : (short) 0;
        if ((b2 & 32) != 0) {
            a(bVar, i2);
            i -= 5;
        }
        bVar.a(z, i2, -1, a(a(i, b2, eoJ), eoJ, b2, i2));
    }

    private List<c> a(int i, short s, byte b2, int i2) throws IOException {
        a aVar = this.psR;
        this.psR.d = i;
        aVar.f3980a = i;
        this.psR.psT = s;
        this.psR.b = b2;
        this.psR.c = i2;
        this.psS.a();
        return this.psS.b();
    }

    private void b(b bVar, int i, byte b2, int i2) throws IOException {
        if (i2 == 0) {
            throw e.j("PROTOCOL_ERROR: TYPE_DATA streamId == 0", new Object[0]);
        }
        boolean z = (b2 & 1) != 0;
        if ((b2 & 32) != 0) {
            throw e.j("PROTOCOL_ERROR: FLAG_COMPRESSED without SETTINGS_COMPRESS_DATA", new Object[0]);
        }
        short eoJ = (b2 & 8) != 0 ? (short) (this.prV.eoJ() & 255) : (short) 0;
        bVar.a(z, i2, this.prV, a(i, b2, eoJ));
        this.prV.h(eoJ);
    }

    private void c(b bVar, int i, byte b2, int i2) throws IOException {
        if (i != 5) {
            throw e.j("TYPE_PRIORITY length: %d != 5", Integer.valueOf(i));
        }
        if (i2 == 0) {
            throw e.j("TYPE_PRIORITY streamId == 0", new Object[0]);
        }
        a(bVar, i2);
    }

    private void a(b bVar, int i) throws IOException {
        int j = this.prV.j();
        bVar.a(i, j & Integer.MAX_VALUE, (this.prV.eoJ() & 255) + 1, (Integer.MIN_VALUE & j) != 0);
    }

    private void d(b bVar, int i, byte b2, int i2) throws IOException {
        if (i != 4) {
            throw e.j("TYPE_RST_STREAM length: %d != 4", Integer.valueOf(i));
        }
        if (i2 == 0) {
            throw e.j("TYPE_RST_STREAM streamId == 0", new Object[0]);
        }
        int j = this.prV.j();
        com.bytedance.sdk.a.b.a.e.b a2 = com.bytedance.sdk.a.b.a.e.b.a(j);
        if (a2 == null) {
            throw e.j("TYPE_RST_STREAM unexpected error code: %d", Integer.valueOf(j));
        }
        bVar.a(i2, a2);
    }

    private void e(b bVar, int i, byte b2, int i2) throws IOException {
        if (i2 != 0) {
            throw e.j("TYPE_SETTINGS streamId != 0", new Object[0]);
        }
        if ((b2 & 1) != 0) {
            if (i != 0) {
                throw e.j("FRAME_SIZE_ERROR ack frame should be empty!", new Object[0]);
            }
            bVar.a();
        } else if (i % 6 != 0) {
            throw e.j("TYPE_SETTINGS length %% 6 != 0: %s", Integer.valueOf(i));
        } else {
            n nVar = new n();
            for (int i3 = 0; i3 < i; i3 += 6) {
                short eoK = this.prV.eoK();
                int j = this.prV.j();
                switch (eoK) {
                    case 2:
                        if (j != 0 && j != 1) {
                            throw e.j("PROTOCOL_ERROR SETTINGS_ENABLE_PUSH != 0 or 1", new Object[0]);
                        }
                        break;
                    case 3:
                        eoK = 4;
                        break;
                    case 4:
                        eoK = 7;
                        if (j < 0) {
                            throw e.j("PROTOCOL_ERROR SETTINGS_INITIAL_WINDOW_SIZE > 2^31 - 1", new Object[0]);
                        }
                        break;
                    case 5:
                        if (j < 16384 || j > 16777215) {
                            throw e.j("PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: %s", Integer.valueOf(j));
                        }
                        break;
                        break;
                }
                nVar.dV(eoK, j);
            }
            bVar.a(false, nVar);
        }
    }

    private void f(b bVar, int i, byte b2, int i2) throws IOException {
        if (i2 == 0) {
            throw e.j("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0", new Object[0]);
        }
        short eoJ = (b2 & 8) != 0 ? (short) (this.prV.eoJ() & 255) : (short) 0;
        bVar.b(i2, this.prV.j() & Integer.MAX_VALUE, a(a(i - 4, b2, eoJ), eoJ, b2, i2));
    }

    private void g(b bVar, int i, byte b2, int i2) throws IOException {
        if (i != 8) {
            throw e.j("TYPE_PING length != 8: %s", Integer.valueOf(i));
        }
        if (i2 != 0) {
            throw e.j("TYPE_PING streamId != 0", new Object[0]);
        }
        bVar.b((b2 & 1) != 0, this.prV.j(), this.prV.j());
    }

    private void h(b bVar, int i, byte b2, int i2) throws IOException {
        if (i < 8) {
            throw e.j("TYPE_GOAWAY length < 8: %s", Integer.valueOf(i));
        }
        if (i2 != 0) {
            throw e.j("TYPE_GOAWAY streamId != 0", new Object[0]);
        }
        int j = this.prV.j();
        int j2 = this.prV.j();
        int i3 = i - 8;
        com.bytedance.sdk.a.b.a.e.b a2 = com.bytedance.sdk.a.b.a.e.b.a(j2);
        if (a2 == null) {
            throw e.j("TYPE_GOAWAY unexpected error code: %d", Integer.valueOf(j2));
        }
        com.bytedance.sdk.a.a.f fVar = com.bytedance.sdk.a.a.f.b;
        if (i3 > 0) {
            fVar = this.prV.ii(i3);
        }
        bVar.a(j, a2, fVar);
    }

    private void i(b bVar, int i, byte b2, int i2) throws IOException {
        if (i != 4) {
            throw e.j("TYPE_WINDOW_UPDATE length !=4: %s", Integer.valueOf(i));
        }
        long j = this.prV.j() & 2147483647L;
        if (j == 0) {
            throw e.j("windowSizeIncrement was 0", Long.valueOf(j));
        }
        bVar.a(i2, j);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.prV.close();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static final class a implements s {

        /* renamed from: a  reason: collision with root package name */
        int f3980a;
        byte b;
        int c;
        int d;
        short psT;
        private final com.bytedance.sdk.a.a.e psl;

        a(com.bytedance.sdk.a.a.e eVar) {
            this.psl = eVar;
        }

        @Override // com.bytedance.sdk.a.a.s
        public long b(com.bytedance.sdk.a.a.c cVar, long j) throws IOException {
            while (this.d == 0) {
                this.psl.h(this.psT);
                this.psT = (short) 0;
                if ((this.b & 4) != 0) {
                    return -1L;
                }
                b();
            }
            long b = this.psl.b(cVar, Math.min(j, this.d));
            if (b != -1) {
                this.d = (int) (this.d - b);
                return b;
            }
            return -1L;
        }

        @Override // com.bytedance.sdk.a.a.s
        public t eoF() {
            return this.psl.eoF();
        }

        @Override // com.bytedance.sdk.a.a.s, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
        }

        private void b() throws IOException {
            int i = this.c;
            int a2 = h.a(this.psl);
            this.d = a2;
            this.f3980a = a2;
            byte eoJ = (byte) (this.psl.eoJ() & 255);
            this.b = (byte) (this.psl.eoJ() & 255);
            if (h.f3979a.isLoggable(Level.FINE)) {
                h.f3979a.fine(e.a(true, this.c, this.f3980a, eoJ, this.b));
            }
            this.c = this.psl.j() & Integer.MAX_VALUE;
            if (eoJ != 9) {
                throw e.j("%s != TYPE_CONTINUATION", Byte.valueOf(eoJ));
            }
            if (this.c != i) {
                throw e.j("TYPE_CONTINUATION streamId changed", new Object[0]);
            }
        }
    }

    static int a(com.bytedance.sdk.a.a.e eVar) throws IOException {
        return ((eVar.eoJ() & 255) << 16) | ((eVar.eoJ() & 255) << 8) | (eVar.eoJ() & 255);
    }

    static int a(int i, byte b2, short s) throws IOException {
        if ((b2 & 8) != 0) {
            i--;
        }
        if (s > i) {
            throw e.j("PROTOCOL_ERROR padding %s > remaining length %s", Short.valueOf(s), Integer.valueOf(i));
        }
        return (short) (i - s);
    }
}
