package com.bytedance.sdk.openadsdk.core.video.a.a;

import com.bytedance.sdk.openadsdk.j.e;
import com.bytedance.sdk.openadsdk.j.g;
import com.bytedance.sdk.openadsdk.utils.u;
import com.yy.mediaframework.stat.VideoDataStatistic;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes6.dex */
public class b implements a {

    /* renamed from: a  reason: collision with root package name */
    public File f4520a;
    private RandomAccessFile b;
    private String d;
    private long f;
    private volatile boolean h;
    private boolean j;
    private String k;
    private volatile long c = -2147483648L;
    private final Object e = new Object();
    private volatile boolean g = false;
    private volatile boolean i = false;

    /* JADX DEBUG: Marked for inline */
    /* JADX DEBUG: Method not inlined, still used in: [com.bytedance.sdk.openadsdk.core.video.a.a.b.1.run():void] */
    static /* synthetic */ long a(b bVar, long j) {
        bVar.c = j;
        return j;
    }

    /* JADX DEBUG: Marked for inline */
    /* JADX DEBUG: Method not inlined, still used in: [com.bytedance.sdk.openadsdk.core.video.a.a.b.1.run():void] */
    static /* synthetic */ String a(b bVar) {
        return bVar.d;
    }

    /* JADX DEBUG: Marked for inline */
    /* JADX DEBUG: Method not inlined, still used in: [com.bytedance.sdk.openadsdk.core.video.a.a.b.1.run():void] */
    static /* synthetic */ boolean a(b bVar, boolean z) {
        bVar.i = z;
        return z;
    }

    /* JADX DEBUG: Marked for inline */
    /* JADX DEBUG: Method not inlined, still used in: [com.bytedance.sdk.openadsdk.core.video.a.a.b.1.run():void] */
    static /* synthetic */ boolean b(b bVar) {
        return bVar.i;
    }

    /* JADX DEBUG: Marked for inline */
    /* JADX DEBUG: Method not inlined, still used in: [com.bytedance.sdk.openadsdk.core.video.a.a.b.1.run():void] */
    static /* synthetic */ boolean b(b bVar, boolean z) {
        bVar.h = z;
        return z;
    }

    /* JADX DEBUG: Marked for inline */
    /* JADX DEBUG: Method not inlined, still used in: [com.bytedance.sdk.openadsdk.core.video.a.a.b.1.run():void] */
    static /* synthetic */ long c(b bVar) {
        return bVar.c;
    }

    /* JADX DEBUG: Marked for inline */
    /* JADX DEBUG: Method not inlined, still used in: [com.bytedance.sdk.openadsdk.core.video.a.a.b.1.run():void] */
    static /* synthetic */ long d(b bVar) {
        return bVar.f;
    }

    /* JADX DEBUG: Marked for inline */
    /* JADX DEBUG: Method not inlined, still used in: [com.bytedance.sdk.openadsdk.core.video.a.a.b.1.run():void] */
    static /* synthetic */ Object e(b bVar) {
        return bVar.e;
    }

    /* JADX DEBUG: Marked for inline */
    /* JADX DEBUG: Method not inlined, still used in: [com.bytedance.sdk.openadsdk.core.video.a.a.b.1.run():void] */
    static /* synthetic */ String f(b bVar) {
        return bVar.k;
    }

    /* JADX DEBUG: Marked for inline */
    /* JADX DEBUG: Method not inlined, still used in: [com.bytedance.sdk.openadsdk.core.video.a.a.b.1.run():void] */
    static /* synthetic */ void g(b bVar) throws IOException {
        bVar.h();
    }

    /* JADX DEBUG: Marked for inline */
    /* JADX DEBUG: Method not inlined, still used in: [com.bytedance.sdk.openadsdk.core.video.a.a.b.1.run():void] */
    static /* synthetic */ void h(b bVar) throws IOException {
        bVar.g();
    }

    /* JADX DEBUG: Marked for inline */
    /* JADX DEBUG: Method not inlined, still used in: [com.bytedance.sdk.openadsdk.core.video.a.a.b.1.run():void] */
    static /* synthetic */ boolean i(b bVar) {
        return bVar.g;
    }

    /* JADX DEBUG: Marked for inline */
    /* JADX DEBUG: Method not inlined, still used in: [com.bytedance.sdk.openadsdk.core.video.a.a.b.1.run():void] */
    static /* synthetic */ RandomAccessFile j(b bVar) {
        return bVar.b;
    }

    public b(String str, String str2, File file) {
        this.f = 0L;
        this.h = false;
        this.d = str;
        this.k = str2;
        try {
            this.f4520a = file;
            boolean f = f();
            this.j = this.j;
            this.b = new RandomAccessFile(this.f4520a, f ? "r" : VideoDataStatistic.AnchorHiidoCoreStatisticKey.CaptureRealResolutionWidth);
            this.f = e();
            if (!f) {
                this.h = true;
                d();
            }
        } catch (IOException e) {
            u.c("VideoCacheImpl", "Error using file " + file + " as disc cache");
        }
    }

    public void d() {
        e.a(new g() { // from class: com.bytedance.sdk.openadsdk.core.video.a.a.b.1
            /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
                jadx.core.utils.exceptions.JadxRuntimeException: Found unreachable blocks
                	at jadx.core.dex.visitors.blocks.DominatorTree.sortBlocks(DominatorTree.java:35)
                	at jadx.core.dex.visitors.blocks.DominatorTree.compute(DominatorTree.java:25)
                	at jadx.core.dex.visitors.blocks.BlockProcessor.computeDominators(BlockProcessor.java:202)
                	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:45)
                	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
                */
            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [128=4, 129=4, 130=4, 132=4, 133=4, 110=5, 112=4, 113=4, 115=4, 116=4, 119=4, 120=4, 123=4, 124=4] */
            @Override // java.lang.Runnable
            public void run() {
                /*
                    r14 = this;
                    r8 = 0
                    r2 = 0
                    r5 = 0
                    com.bytedance.sdk.openadsdk.core.video.a.a.b r0 = com.bytedance.sdk.openadsdk.core.video.a.a.b.this     // Catch: java.lang.Throwable -> L24b
                    long r0 = r0.e()     // Catch: java.lang.Throwable -> L24b
                    com.bytedance.sdk.a.b.z r3 = new com.bytedance.sdk.a.b.z     // Catch: java.lang.Throwable -> L24b
                    r3.<init>()     // Catch: java.lang.Throwable -> L24b
                    com.bytedance.sdk.a.b.ab$a r4 = new com.bytedance.sdk.a.b.ab$a     // Catch: java.lang.Throwable -> L24b
                    r4.<init>()     // Catch: java.lang.Throwable -> L24b
                    java.lang.String r6 = "RANGE"
                    java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L24b
                    r7.<init>()     // Catch: java.lang.Throwable -> L24b
                    java.lang.String r10 = "bytes="
                    java.lang.StringBuilder r7 = r7.append(r10)     // Catch: java.lang.Throwable -> L24b
                    java.lang.StringBuilder r7 = r7.append(r0)     // Catch: java.lang.Throwable -> L24b
                    java.lang.String r10 = "-"
                    java.lang.StringBuilder r7 = r7.append(r10)     // Catch: java.lang.Throwable -> L24b
                    java.lang.String r7 = r7.toString()     // Catch: java.lang.Throwable -> L24b
                    com.bytedance.sdk.a.b.ab$a r4 = r4.ho(r6, r7)     // Catch: java.lang.Throwable -> L24b
                    com.bytedance.sdk.openadsdk.core.video.a.a.b r6 = com.bytedance.sdk.openadsdk.core.video.a.a.b.this     // Catch: java.lang.Throwable -> L24b
                    java.lang.String r6 = com.bytedance.sdk.openadsdk.core.video.a.a.b.a(r6)     // Catch: java.lang.Throwable -> L24b
                    com.bytedance.sdk.a.b.ab$a r4 = r4.Zh(r6)     // Catch: java.lang.Throwable -> L24b
                    com.bytedance.sdk.a.b.ab$a r4 = r4.eqN()     // Catch: java.lang.Throwable -> L24b
                    com.bytedance.sdk.a.b.ab r4 = r4.eqQ()     // Catch: java.lang.Throwable -> L24b
                    com.bytedance.sdk.a.b.h r3 = r3.g(r4)     // Catch: java.lang.Throwable -> L24b
                    com.bytedance.sdk.a.b.b r4 = r3.epY()     // Catch: java.lang.Throwable -> L24b
                    com.bytedance.sdk.openadsdk.core.video.a.a.b r3 = com.bytedance.sdk.openadsdk.core.video.a.a.b.this     // Catch: java.lang.Throwable -> L251
                    boolean r6 = r4.d()     // Catch: java.lang.Throwable -> L251
                    com.bytedance.sdk.openadsdk.core.video.a.a.b.a(r3, r6)     // Catch: java.lang.Throwable -> L251
                    com.bytedance.sdk.a.b.c r3 = r4.epU()     // Catch: java.lang.Throwable -> L251
                    com.bytedance.sdk.openadsdk.core.video.a.a.b r6 = com.bytedance.sdk.openadsdk.core.video.a.a.b.this     // Catch: java.lang.Throwable -> L256
                    boolean r6 = com.bytedance.sdk.openadsdk.core.video.a.a.b.b(r6)     // Catch: java.lang.Throwable -> L256
                    if (r6 == 0) goto L25a
                    if (r3 == 0) goto L25a
                    com.bytedance.sdk.openadsdk.core.video.a.a.b r6 = com.bytedance.sdk.openadsdk.core.video.a.a.b.this     // Catch: java.lang.Throwable -> L256
                    long r10 = r3.b()     // Catch: java.lang.Throwable -> L256
                    long r0 = r0 + r10
                    com.bytedance.sdk.openadsdk.core.video.a.a.b.a(r6, r0)     // Catch: java.lang.Throwable -> L256
                    java.io.InputStream r2 = r3.c()     // Catch: java.lang.Throwable -> L256
                    r1 = r2
                L76:
                    if (r1 != 0) goto Ld8
                    com.bytedance.sdk.openadsdk.core.video.a.a.b r0 = com.bytedance.sdk.openadsdk.core.video.a.a.b.this
                    java.lang.String r0 = com.bytedance.sdk.openadsdk.core.video.a.a.b.f(r0)
                    com.bytedance.sdk.openadsdk.core.video.a.a.b(r0)
                    if (r1 == 0) goto L86
                    r1.close()     // Catch: java.io.IOException -> Ld3
                L86:
                    if (r3 == 0) goto L8b
                    r3.close()     // Catch: java.io.IOException -> Ld3
                L8b:
                    if (r4 == 0) goto L90
                    r4.close()     // Catch: java.io.IOException -> Ld3
                L90:
                    com.bytedance.sdk.openadsdk.core.video.a.a.b r0 = com.bytedance.sdk.openadsdk.core.video.a.a.b.this     // Catch: java.io.IOException -> Ld3
                    boolean r0 = com.bytedance.sdk.openadsdk.core.video.a.a.b.b(r0)     // Catch: java.io.IOException -> Ld3
                    if (r0 == 0) goto Lcd
                    com.bytedance.sdk.openadsdk.core.video.a.a.b r0 = com.bytedance.sdk.openadsdk.core.video.a.a.b.this     // Catch: java.io.IOException -> Ld3
                    long r0 = r0.e()     // Catch: java.io.IOException -> Ld3
                    com.bytedance.sdk.openadsdk.core.video.a.a.b r2 = com.bytedance.sdk.openadsdk.core.video.a.a.b.this     // Catch: java.io.IOException -> Ld3
                    long r2 = com.bytedance.sdk.openadsdk.core.video.a.a.b.c(r2)     // Catch: java.io.IOException -> Ld3
                    int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
                    if (r0 != 0) goto Lcd
                    com.bytedance.sdk.openadsdk.core.video.a.a.b r0 = com.bytedance.sdk.openadsdk.core.video.a.a.b.this     // Catch: java.io.IOException -> Ld3
                    com.bytedance.sdk.openadsdk.core.video.a.a.b.g(r0)     // Catch: java.io.IOException -> Ld3
                Lad:
                    com.bytedance.sdk.openadsdk.core.video.a.a.b r0 = com.bytedance.sdk.openadsdk.core.video.a.a.b.this     // Catch: java.io.IOException -> Ld3
                    r1 = 0
                    com.bytedance.sdk.openadsdk.core.video.a.a.b.b(r0, r1)     // Catch: java.io.IOException -> Ld3
                    com.bytedance.sdk.openadsdk.core.video.a.a.b r0 = com.bytedance.sdk.openadsdk.core.video.a.a.b.this     // Catch: java.io.IOException -> Ld3
                    boolean r0 = com.bytedance.sdk.openadsdk.core.video.a.a.b.i(r0)     // Catch: java.io.IOException -> Ld3
                    if (r0 == 0) goto Lcc
                    com.bytedance.sdk.openadsdk.core.video.a.a.b r0 = com.bytedance.sdk.openadsdk.core.video.a.a.b.this     // Catch: java.io.IOException -> Ld3
                    java.io.RandomAccessFile r0 = com.bytedance.sdk.openadsdk.core.video.a.a.b.j(r0)     // Catch: java.io.IOException -> Ld3
                    if (r0 == 0) goto Lcc
                    com.bytedance.sdk.openadsdk.core.video.a.a.b r0 = com.bytedance.sdk.openadsdk.core.video.a.a.b.this     // Catch: java.io.IOException -> Ld3
                    java.io.RandomAccessFile r0 = com.bytedance.sdk.openadsdk.core.video.a.a.b.j(r0)     // Catch: java.io.IOException -> Ld3
                    r0.close()     // Catch: java.io.IOException -> Ld3
                Lcc:
                    return
                Lcd:
                    com.bytedance.sdk.openadsdk.core.video.a.a.b r0 = com.bytedance.sdk.openadsdk.core.video.a.a.b.this     // Catch: java.io.IOException -> Ld3
                    com.bytedance.sdk.openadsdk.core.video.a.a.b.h(r0)     // Catch: java.io.IOException -> Ld3
                    goto Lad
                Ld3:
                    r0 = move-exception
                    r0.printStackTrace()
                    goto Lcc
                Ld8:
                    r0 = 16384(0x4000, float:2.2959E-41)
                    byte[] r2 = new byte[r0]     // Catch: java.lang.Throwable -> L115
                    r0 = r5
                    r6 = r8
                Lde:
                    int r10 = 16384 - r0
                    int r10 = r1.read(r2, r0, r10)     // Catch: java.lang.Throwable -> L115
                    r11 = -1
                    if (r10 == r11) goto L175
                    int r0 = r0 + r10
                    long r10 = (long) r10     // Catch: java.lang.Throwable -> L115
                    long r6 = r6 + r10
                    r10 = 16384(0x4000, double:8.095E-320)
                    long r10 = r6 % r10
                    int r10 = (r10 > r8 ? 1 : (r10 == r8 ? 0 : -1))
                    if (r10 == 0) goto L103
                    com.bytedance.sdk.openadsdk.core.video.a.a.b r10 = com.bytedance.sdk.openadsdk.core.video.a.a.b.this     // Catch: java.lang.Throwable -> L115
                    long r10 = com.bytedance.sdk.openadsdk.core.video.a.a.b.c(r10)     // Catch: java.lang.Throwable -> L115
                    com.bytedance.sdk.openadsdk.core.video.a.a.b r12 = com.bytedance.sdk.openadsdk.core.video.a.a.b.this     // Catch: java.lang.Throwable -> L115
                    long r12 = com.bytedance.sdk.openadsdk.core.video.a.a.b.d(r12)     // Catch: java.lang.Throwable -> L115
                    long r10 = r10 - r12
                    int r10 = (r6 > r10 ? 1 : (r6 == r10 ? 0 : -1))
                    if (r10 != 0) goto Lde
                L103:
                    com.bytedance.sdk.openadsdk.core.video.a.a.b r10 = com.bytedance.sdk.openadsdk.core.video.a.a.b.this     // Catch: java.lang.Throwable -> L115
                    java.lang.Object r10 = com.bytedance.sdk.openadsdk.core.video.a.a.b.e(r10)     // Catch: java.lang.Throwable -> L115
                    monitor-enter(r10)     // Catch: java.lang.Throwable -> L115
                    com.bytedance.sdk.openadsdk.core.video.a.a.b r11 = com.bytedance.sdk.openadsdk.core.video.a.a.b.this     // Catch: java.lang.Throwable -> L112
                    r11.a(r2, r0)     // Catch: java.lang.Throwable -> L112
                    monitor-exit(r10)     // Catch: java.lang.Throwable -> L112
                    r0 = r5
                    goto Lde
                L112:
                    r0 = move-exception
                    monitor-exit(r10)     // Catch: java.lang.Throwable -> L112
                    throw r0     // Catch: java.lang.Throwable -> L115
                L115:
                    r0 = move-exception
                L116:
                    r0.printStackTrace()     // Catch: java.lang.Throwable -> L249
                    com.bytedance.sdk.openadsdk.core.video.a.a.b r0 = com.bytedance.sdk.openadsdk.core.video.a.a.b.this
                    java.lang.String r0 = com.bytedance.sdk.openadsdk.core.video.a.a.b.f(r0)
                    com.bytedance.sdk.openadsdk.core.video.a.a.b(r0)
                    if (r1 == 0) goto L127
                    r1.close()     // Catch: java.io.IOException -> L16f
                L127:
                    if (r3 == 0) goto L12c
                    r3.close()     // Catch: java.io.IOException -> L16f
                L12c:
                    if (r4 == 0) goto L131
                    r4.close()     // Catch: java.io.IOException -> L16f
                L131:
                    com.bytedance.sdk.openadsdk.core.video.a.a.b r0 = com.bytedance.sdk.openadsdk.core.video.a.a.b.this     // Catch: java.io.IOException -> L16f
                    boolean r0 = com.bytedance.sdk.openadsdk.core.video.a.a.b.b(r0)     // Catch: java.io.IOException -> L16f
                    if (r0 == 0) goto L1d7
                    com.bytedance.sdk.openadsdk.core.video.a.a.b r0 = com.bytedance.sdk.openadsdk.core.video.a.a.b.this     // Catch: java.io.IOException -> L16f
                    long r0 = r0.e()     // Catch: java.io.IOException -> L16f
                    com.bytedance.sdk.openadsdk.core.video.a.a.b r2 = com.bytedance.sdk.openadsdk.core.video.a.a.b.this     // Catch: java.io.IOException -> L16f
                    long r2 = com.bytedance.sdk.openadsdk.core.video.a.a.b.c(r2)     // Catch: java.io.IOException -> L16f
                    int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
                    if (r0 != 0) goto L1d7
                    com.bytedance.sdk.openadsdk.core.video.a.a.b r0 = com.bytedance.sdk.openadsdk.core.video.a.a.b.this     // Catch: java.io.IOException -> L16f
                    com.bytedance.sdk.openadsdk.core.video.a.a.b.g(r0)     // Catch: java.io.IOException -> L16f
                L14e:
                    com.bytedance.sdk.openadsdk.core.video.a.a.b r0 = com.bytedance.sdk.openadsdk.core.video.a.a.b.this     // Catch: java.io.IOException -> L16f
                    r1 = 0
                    com.bytedance.sdk.openadsdk.core.video.a.a.b.b(r0, r1)     // Catch: java.io.IOException -> L16f
                    com.bytedance.sdk.openadsdk.core.video.a.a.b r0 = com.bytedance.sdk.openadsdk.core.video.a.a.b.this     // Catch: java.io.IOException -> L16f
                    boolean r0 = com.bytedance.sdk.openadsdk.core.video.a.a.b.i(r0)     // Catch: java.io.IOException -> L16f
                    if (r0 == 0) goto Lcc
                    com.bytedance.sdk.openadsdk.core.video.a.a.b r0 = com.bytedance.sdk.openadsdk.core.video.a.a.b.this     // Catch: java.io.IOException -> L16f
                    java.io.RandomAccessFile r0 = com.bytedance.sdk.openadsdk.core.video.a.a.b.j(r0)     // Catch: java.io.IOException -> L16f
                    if (r0 == 0) goto Lcc
                    com.bytedance.sdk.openadsdk.core.video.a.a.b r0 = com.bytedance.sdk.openadsdk.core.video.a.a.b.this     // Catch: java.io.IOException -> L16f
                    java.io.RandomAccessFile r0 = com.bytedance.sdk.openadsdk.core.video.a.a.b.j(r0)     // Catch: java.io.IOException -> L16f
                    r0.close()     // Catch: java.io.IOException -> L16f
                    goto Lcc
                L16f:
                    r0 = move-exception
                    r0.printStackTrace()
                    goto Lcc
                L175:
                    com.bytedance.sdk.openadsdk.core.video.a.a.b r0 = com.bytedance.sdk.openadsdk.core.video.a.a.b.this
                    java.lang.String r0 = com.bytedance.sdk.openadsdk.core.video.a.a.b.f(r0)
                    com.bytedance.sdk.openadsdk.core.video.a.a.b(r0)
                    if (r1 == 0) goto L183
                    r1.close()     // Catch: java.io.IOException -> L1cb
                L183:
                    if (r3 == 0) goto L188
                    r3.close()     // Catch: java.io.IOException -> L1cb
                L188:
                    if (r4 == 0) goto L18d
                    r4.close()     // Catch: java.io.IOException -> L1cb
                L18d:
                    com.bytedance.sdk.openadsdk.core.video.a.a.b r0 = com.bytedance.sdk.openadsdk.core.video.a.a.b.this     // Catch: java.io.IOException -> L1cb
                    boolean r0 = com.bytedance.sdk.openadsdk.core.video.a.a.b.b(r0)     // Catch: java.io.IOException -> L1cb
                    if (r0 == 0) goto L1d1
                    com.bytedance.sdk.openadsdk.core.video.a.a.b r0 = com.bytedance.sdk.openadsdk.core.video.a.a.b.this     // Catch: java.io.IOException -> L1cb
                    long r0 = r0.e()     // Catch: java.io.IOException -> L1cb
                    com.bytedance.sdk.openadsdk.core.video.a.a.b r2 = com.bytedance.sdk.openadsdk.core.video.a.a.b.this     // Catch: java.io.IOException -> L1cb
                    long r2 = com.bytedance.sdk.openadsdk.core.video.a.a.b.c(r2)     // Catch: java.io.IOException -> L1cb
                    int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
                    if (r0 != 0) goto L1d1
                    com.bytedance.sdk.openadsdk.core.video.a.a.b r0 = com.bytedance.sdk.openadsdk.core.video.a.a.b.this     // Catch: java.io.IOException -> L1cb
                    com.bytedance.sdk.openadsdk.core.video.a.a.b.g(r0)     // Catch: java.io.IOException -> L1cb
                L1aa:
                    com.bytedance.sdk.openadsdk.core.video.a.a.b r0 = com.bytedance.sdk.openadsdk.core.video.a.a.b.this     // Catch: java.io.IOException -> L1cb
                    r1 = 0
                    com.bytedance.sdk.openadsdk.core.video.a.a.b.b(r0, r1)     // Catch: java.io.IOException -> L1cb
                    com.bytedance.sdk.openadsdk.core.video.a.a.b r0 = com.bytedance.sdk.openadsdk.core.video.a.a.b.this     // Catch: java.io.IOException -> L1cb
                    boolean r0 = com.bytedance.sdk.openadsdk.core.video.a.a.b.i(r0)     // Catch: java.io.IOException -> L1cb
                    if (r0 == 0) goto Lcc
                    com.bytedance.sdk.openadsdk.core.video.a.a.b r0 = com.bytedance.sdk.openadsdk.core.video.a.a.b.this     // Catch: java.io.IOException -> L1cb
                    java.io.RandomAccessFile r0 = com.bytedance.sdk.openadsdk.core.video.a.a.b.j(r0)     // Catch: java.io.IOException -> L1cb
                    if (r0 == 0) goto Lcc
                    com.bytedance.sdk.openadsdk.core.video.a.a.b r0 = com.bytedance.sdk.openadsdk.core.video.a.a.b.this     // Catch: java.io.IOException -> L1cb
                    java.io.RandomAccessFile r0 = com.bytedance.sdk.openadsdk.core.video.a.a.b.j(r0)     // Catch: java.io.IOException -> L1cb
                    r0.close()     // Catch: java.io.IOException -> L1cb
                    goto Lcc
                L1cb:
                    r0 = move-exception
                    r0.printStackTrace()
                    goto Lcc
                L1d1:
                    com.bytedance.sdk.openadsdk.core.video.a.a.b r0 = com.bytedance.sdk.openadsdk.core.video.a.a.b.this     // Catch: java.io.IOException -> L1cb
                    com.bytedance.sdk.openadsdk.core.video.a.a.b.h(r0)     // Catch: java.io.IOException -> L1cb
                    goto L1aa
                L1d7:
                    com.bytedance.sdk.openadsdk.core.video.a.a.b r0 = com.bytedance.sdk.openadsdk.core.video.a.a.b.this     // Catch: java.io.IOException -> L16f
                    com.bytedance.sdk.openadsdk.core.video.a.a.b.h(r0)     // Catch: java.io.IOException -> L16f
                    goto L14e
                L1de:
                    r0 = move-exception
                    r1 = r2
                    r3 = r2
                    r4 = r2
                L1e2:
                    com.bytedance.sdk.openadsdk.core.video.a.a.b r2 = com.bytedance.sdk.openadsdk.core.video.a.a.b.this
                    java.lang.String r2 = com.bytedance.sdk.openadsdk.core.video.a.a.b.f(r2)
                    com.bytedance.sdk.openadsdk.core.video.a.a.b(r2)
                    if (r1 == 0) goto L1f0
                    r1.close()     // Catch: java.io.IOException -> L23d
                L1f0:
                    if (r3 == 0) goto L1f5
                    r3.close()     // Catch: java.io.IOException -> L23d
                L1f5:
                    if (r4 == 0) goto L1fa
                    r4.close()     // Catch: java.io.IOException -> L23d
                L1fa:
                    com.bytedance.sdk.openadsdk.core.video.a.a.b r1 = com.bytedance.sdk.openadsdk.core.video.a.a.b.this     // Catch: java.io.IOException -> L23d
                    boolean r1 = com.bytedance.sdk.openadsdk.core.video.a.a.b.b(r1)     // Catch: java.io.IOException -> L23d
                    if (r1 == 0) goto L237
                    com.bytedance.sdk.openadsdk.core.video.a.a.b r1 = com.bytedance.sdk.openadsdk.core.video.a.a.b.this     // Catch: java.io.IOException -> L23d
                    long r2 = r1.e()     // Catch: java.io.IOException -> L23d
                    com.bytedance.sdk.openadsdk.core.video.a.a.b r1 = com.bytedance.sdk.openadsdk.core.video.a.a.b.this     // Catch: java.io.IOException -> L23d
                    long r4 = com.bytedance.sdk.openadsdk.core.video.a.a.b.c(r1)     // Catch: java.io.IOException -> L23d
                    int r1 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
                    if (r1 != 0) goto L237
                    com.bytedance.sdk.openadsdk.core.video.a.a.b r1 = com.bytedance.sdk.openadsdk.core.video.a.a.b.this     // Catch: java.io.IOException -> L23d
                    com.bytedance.sdk.openadsdk.core.video.a.a.b.g(r1)     // Catch: java.io.IOException -> L23d
                L217:
                    com.bytedance.sdk.openadsdk.core.video.a.a.b r1 = com.bytedance.sdk.openadsdk.core.video.a.a.b.this     // Catch: java.io.IOException -> L23d
                    r2 = 0
                    com.bytedance.sdk.openadsdk.core.video.a.a.b.b(r1, r2)     // Catch: java.io.IOException -> L23d
                    com.bytedance.sdk.openadsdk.core.video.a.a.b r1 = com.bytedance.sdk.openadsdk.core.video.a.a.b.this     // Catch: java.io.IOException -> L23d
                    boolean r1 = com.bytedance.sdk.openadsdk.core.video.a.a.b.i(r1)     // Catch: java.io.IOException -> L23d
                    if (r1 == 0) goto L236
                    com.bytedance.sdk.openadsdk.core.video.a.a.b r1 = com.bytedance.sdk.openadsdk.core.video.a.a.b.this     // Catch: java.io.IOException -> L23d
                    java.io.RandomAccessFile r1 = com.bytedance.sdk.openadsdk.core.video.a.a.b.j(r1)     // Catch: java.io.IOException -> L23d
                    if (r1 == 0) goto L236
                    com.bytedance.sdk.openadsdk.core.video.a.a.b r1 = com.bytedance.sdk.openadsdk.core.video.a.a.b.this     // Catch: java.io.IOException -> L23d
                    java.io.RandomAccessFile r1 = com.bytedance.sdk.openadsdk.core.video.a.a.b.j(r1)     // Catch: java.io.IOException -> L23d
                    r1.close()     // Catch: java.io.IOException -> L23d
                L236:
                    throw r0
                L237:
                    com.bytedance.sdk.openadsdk.core.video.a.a.b r1 = com.bytedance.sdk.openadsdk.core.video.a.a.b.this     // Catch: java.io.IOException -> L23d
                    com.bytedance.sdk.openadsdk.core.video.a.a.b.h(r1)     // Catch: java.io.IOException -> L23d
                    goto L217
                L23d:
                    r1 = move-exception
                    r1.printStackTrace()
                    goto L236
                L242:
                    r0 = move-exception
                    r1 = r2
                    r3 = r2
                    goto L1e2
                L246:
                    r0 = move-exception
                    r1 = r2
                    goto L1e2
                L249:
                    r0 = move-exception
                    goto L1e2
                L24b:
                    r0 = move-exception
                    r1 = r2
                    r3 = r2
                    r4 = r2
                    goto L116
                L251:
                    r0 = move-exception
                    r1 = r2
                    r3 = r2
                    goto L116
                L256:
                    r0 = move-exception
                    r1 = r2
                    goto L116
                L25a:
                    r1 = r2
                    goto L76
                */
                throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.video.a.a.b.AnonymousClass1.run():void");
            }
        });
    }

    public long e() throws IOException {
        try {
            return this.b.length();
        } catch (IOException e) {
            throw new IOException("Error reading length of file " + this.f4520a, e);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.a.a.a
    public int a(long j, byte[] bArr, int i, int i2) throws IOException {
        int i3 = 0;
        try {
            if (j == this.c) {
                return -1;
            }
            while (!this.g) {
                synchronized (this.e) {
                    if (j < e()) {
                        u.c("VideoCacheImpl", "read:  read " + j + " success");
                        this.b.seek(j);
                        i3 = this.b.read(bArr, i, i2);
                    } else {
                        u.c("VideoCacheImpl", "read: wait at " + j + "  file size = " + e());
                        this.e.wait(33L);
                    }
                }
                if (i3 > 0) {
                    return i3;
                }
            }
            return -1;
        } catch (IOException e) {
            throw new IOException(String.format("Error reading %d bytes with offset %d from file[%d bytes] to buffer[%d bytes]", Integer.valueOf(i2), Integer.valueOf(i), Long.valueOf(e()), Integer.valueOf(bArr.length)), e);
        } catch (InterruptedException e2) {
            e2.printStackTrace();
            return -1;
        }
    }

    public void a(byte[] bArr, int i) throws IOException {
        try {
            this.b.seek(e());
            this.b.write(bArr, 0, i);
            this.e.notifyAll();
            u.c("VideoCacheImpl", "append:  pisition =" + e() + "  length =" + i);
        } catch (IOException e) {
            throw new IOException(String.format("Error writing %d bytes to %s from buffer with size %d", Integer.valueOf(i), this.b, Integer.valueOf(bArr.length)), e);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.a.a.a
    public void a() throws IOException {
        try {
            if (!this.h) {
                this.b.close();
            }
            this.g = true;
        } catch (IOException e) {
            throw new IOException("Error closing file " + this.f4520a, e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() throws IOException {
        if (!f()) {
            try {
                synchronized (this.e) {
                    this.f4520a.delete();
                    if (this.b != null) {
                        this.b.close();
                    }
                    this.b = new RandomAccessFile(this.f4520a, "r");
                }
            } catch (IOException e) {
                throw new IOException("Error downloadFail " + this.f4520a, e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() throws IOException {
        if (!f()) {
            try {
                synchronized (this.e) {
                    File file = new File(this.f4520a.getParentFile(), this.f4520a.getName().substring(0, this.f4520a.getName().length() - ".download".length()));
                    if (!this.f4520a.renameTo(file)) {
                        throw new IOException("Error renaming file " + this.f4520a + " to " + file + " for completion!");
                    }
                    this.f4520a = file;
                    if (this.b != null) {
                        this.b.close();
                    }
                    this.b = new RandomAccessFile(this.f4520a, "r");
                }
            } catch (IOException e) {
                throw new IOException("Error opening " + this.f4520a + " as disc cache", e);
            }
        }
    }

    public boolean f() {
        return !this.f4520a.getName().endsWith(".download");
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.a.a.a
    public long b() throws IOException {
        if (f()) {
            this.c = e();
        } else {
            synchronized (this.e) {
                while (this.c == -2147483648L) {
                    try {
                        u.c("VideoCacheImpl", "length: wait");
                        this.e.wait(5L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        throw new IOException("total length InterruptException");
                    }
                }
            }
        }
        return this.c;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.a.a.a
    public boolean c() {
        return this.h;
    }
}
