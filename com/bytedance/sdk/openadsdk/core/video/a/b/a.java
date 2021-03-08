package com.bytedance.sdk.openadsdk.core.video.a.b;

import android.content.Context;
import com.bytedance.sdk.openadsdk.core.video.a.a.c;
import com.bytedance.sdk.openadsdk.j.e;
import com.bytedance.sdk.openadsdk.j.g;
import com.bytedance.sdk.openadsdk.utils.u;
import java.util.HashSet;
/* loaded from: classes6.dex */
public class a {
    private static final HashSet<String> e = new HashSet<>();

    /* renamed from: a  reason: collision with root package name */
    private Context f4523a;
    private long b;
    private String c;
    private String d;

    /* JADX DEBUG: Marked for inline */
    /* JADX DEBUG: Method not inlined, still used in: [com.bytedance.sdk.openadsdk.core.video.a.b.a.1.run():void] */
    static /* synthetic */ String a(a aVar) {
        return aVar.c;
    }

    /* JADX DEBUG: Marked for inline */
    /* JADX DEBUG: Method not inlined, still used in: [com.bytedance.sdk.openadsdk.core.video.a.b.a.1.run():void] */
    static /* synthetic */ long b(a aVar) {
        return aVar.b;
    }

    /* JADX DEBUG: Marked for inline */
    /* JADX DEBUG: Method not inlined, still used in: [com.bytedance.sdk.openadsdk.core.video.a.b.a.1.run():void] */
    static /* synthetic */ Context c(a aVar) {
        return aVar.f4523a;
    }

    /* JADX DEBUG: Marked for inline */
    /* JADX DEBUG: Method not inlined, still used in: [com.bytedance.sdk.openadsdk.core.video.a.b.a.1.run():void] */
    static /* synthetic */ HashSet c() {
        return e;
    }

    /* JADX DEBUG: Marked for inline */
    /* JADX DEBUG: Method not inlined, still used in: [com.bytedance.sdk.openadsdk.core.video.a.b.a.1.run():void] */
    static /* synthetic */ String d(a aVar) {
        return aVar.d;
    }

    public a(Context context, String str, String str2, long j) {
        this.f4523a = context;
        this.b = j;
        this.c = str;
        this.d = str2;
    }

    public boolean a() {
        return c.a(this.f4523a, this.d).exists();
    }

    public void b() {
        if (a()) {
            u.c("VideoPreload", "Cache file is exist");
            return;
        }
        synchronized (e) {
            if (com.bytedance.sdk.openadsdk.core.video.a.a.a(this.d) != null || e.contains(this.d)) {
                u.c("VideoPreload", "Cache file is downloading ...");
            } else {
                e.add(this.d);
                e.a(new g() { // from class: com.bytedance.sdk.openadsdk.core.video.a.b.a.1
                    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
                        jadx.core.utils.exceptions.JadxRuntimeException: Found unreachable blocks
                        	at jadx.core.dex.visitors.blocks.DominatorTree.sortBlocks(DominatorTree.java:35)
                        	at jadx.core.dex.visitors.blocks.DominatorTree.compute(DominatorTree.java:25)
                        	at jadx.core.dex.visitors.blocks.BlockProcessor.computeDominators(BlockProcessor.java:202)
                        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:45)
                        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
                        */
                    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [128=5, 130=5, 131=5, 132=10, 134=5, 135=5, 136=5, 137=5, 138=5, 140=5, 144=5, 147=5, 148=5, 117=5, 118=5, 120=5, 121=5, 123=5, 124=5, 127=5] */
                    @Override // java.lang.Runnable
                    public void run() {
                        /*
                            r8 = this;
                            r2 = 0
                            com.bytedance.sdk.a.b.z r0 = new com.bytedance.sdk.a.b.z
                            r0.<init>()
                            com.bytedance.sdk.a.b.ab$a r1 = new com.bytedance.sdk.a.b.ab$a
                            r1.<init>()
                            java.lang.String r3 = "RANGE"
                            java.lang.StringBuilder r4 = new java.lang.StringBuilder
                            r4.<init>()
                            java.lang.String r5 = "bytes=0-"
                            java.lang.StringBuilder r4 = r4.append(r5)
                            com.bytedance.sdk.openadsdk.core.video.a.b.a r5 = com.bytedance.sdk.openadsdk.core.video.a.b.a.this
                            long r6 = com.bytedance.sdk.openadsdk.core.video.a.b.a.b(r5)
                            java.lang.StringBuilder r4 = r4.append(r6)
                            java.lang.String r4 = r4.toString()
                            com.bytedance.sdk.a.b.ab$a r1 = r1.ho(r3, r4)
                            com.bytedance.sdk.openadsdk.core.video.a.b.a r3 = com.bytedance.sdk.openadsdk.core.video.a.b.a.this
                            java.lang.String r3 = com.bytedance.sdk.openadsdk.core.video.a.b.a.a(r3)
                            com.bytedance.sdk.a.b.ab$a r1 = r1.Zh(r3)
                            com.bytedance.sdk.a.b.ab$a r1 = r1.eqN()
                            com.bytedance.sdk.a.b.ab r1 = r1.eqQ()
                            r3 = 0
                            r4 = 0
                            r6 = 0
                            com.bytedance.sdk.openadsdk.core.video.a.b.a r5 = com.bytedance.sdk.openadsdk.core.video.a.b.a.this
                            android.content.Context r5 = com.bytedance.sdk.openadsdk.core.video.a.b.a.c(r5)
                            com.bytedance.sdk.openadsdk.core.video.a.b.a r7 = com.bytedance.sdk.openadsdk.core.video.a.b.a.this
                            java.lang.String r7 = com.bytedance.sdk.openadsdk.core.video.a.b.a.d(r7)
                            java.io.File r7 = com.bytedance.sdk.openadsdk.core.video.a.a.c.b(r5, r7)
                            com.bytedance.sdk.a.b.h r0 = r0.g(r1)     // Catch: java.lang.Throwable -> L30a
                            com.bytedance.sdk.a.b.b r5 = r0.epY()     // Catch: java.lang.Throwable -> L30a
                            boolean r0 = r5.d()     // Catch: java.lang.Throwable -> L311
                            if (r0 != 0) goto Ld8
                            if (r2 == 0) goto L64
                            r6.close()     // Catch: java.io.IOException -> Lcf
                        L64:
                            if (r2 == 0) goto L69
                            r4.close()     // Catch: java.io.IOException -> Lcf
                        L69:
                            if (r2 == 0) goto L6e
                            r3.close()     // Catch: java.io.IOException -> Lcf
                        L6e:
                            if (r5 == 0) goto L73
                            r5.close()     // Catch: java.io.IOException -> Lcf
                        L73:
                            java.util.HashSet r1 = com.bytedance.sdk.openadsdk.core.video.a.b.a.c()     // Catch: java.io.IOException -> Lcf
                            monitor-enter(r1)     // Catch: java.io.IOException -> Lcf
                            java.util.HashSet r0 = com.bytedance.sdk.openadsdk.core.video.a.b.a.c()     // Catch: java.lang.Throwable -> Lcc
                            com.bytedance.sdk.openadsdk.core.video.a.b.a r2 = com.bytedance.sdk.openadsdk.core.video.a.b.a.this     // Catch: java.lang.Throwable -> Lcc
                            java.lang.String r2 = com.bytedance.sdk.openadsdk.core.video.a.b.a.d(r2)     // Catch: java.lang.Throwable -> Lcc
                            r0.remove(r2)     // Catch: java.lang.Throwable -> Lcc
                            monitor-exit(r1)     // Catch: java.lang.Throwable -> Lcc
                            com.bytedance.sdk.openadsdk.core.video.a.b.a r0 = com.bytedance.sdk.openadsdk.core.video.a.b.a.this     // Catch: java.io.IOException -> Lcf
                            java.lang.String r0 = com.bytedance.sdk.openadsdk.core.video.a.b.a.d(r0)     // Catch: java.io.IOException -> Lcf
                            com.bytedance.sdk.openadsdk.core.video.a.b r0 = com.bytedance.sdk.openadsdk.core.video.a.a.a(r0)     // Catch: java.io.IOException -> Lcf
                            if (r0 != 0) goto Ld4
                            com.bytedance.sdk.openadsdk.core.video.a.b.a r0 = com.bytedance.sdk.openadsdk.core.video.a.b.a.this     // Catch: java.io.IOException -> Lcf
                            android.content.Context r0 = com.bytedance.sdk.openadsdk.core.video.a.b.a.c(r0)     // Catch: java.io.IOException -> Lcf
                            com.bytedance.sdk.openadsdk.core.video.a.b.a r1 = com.bytedance.sdk.openadsdk.core.video.a.b.a.this     // Catch: java.io.IOException -> Lcf
                            java.lang.String r1 = com.bytedance.sdk.openadsdk.core.video.a.b.a.d(r1)     // Catch: java.io.IOException -> Lcf
                            java.io.File r0 = com.bytedance.sdk.openadsdk.core.video.a.a.c.a(r0, r1)     // Catch: java.io.IOException -> Lcf
                            boolean r0 = r7.renameTo(r0)     // Catch: java.io.IOException -> Lcf
                            if (r0 != 0) goto Lab
                            r7.delete()     // Catch: java.io.IOException -> Lcf
                        Lab:
                            java.lang.String r0 = "VideoPreload"
                            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.io.IOException -> Lcf
                            r1.<init>()     // Catch: java.io.IOException -> Lcf
                            java.lang.String r2 = "preload success md5 = "
                            java.lang.StringBuilder r1 = r1.append(r2)     // Catch: java.io.IOException -> Lcf
                            com.bytedance.sdk.openadsdk.core.video.a.b.a r2 = com.bytedance.sdk.openadsdk.core.video.a.b.a.this     // Catch: java.io.IOException -> Lcf
                            java.lang.String r2 = com.bytedance.sdk.openadsdk.core.video.a.b.a.d(r2)     // Catch: java.io.IOException -> Lcf
                            java.lang.StringBuilder r1 = r1.append(r2)     // Catch: java.io.IOException -> Lcf
                            java.lang.String r1 = r1.toString()     // Catch: java.io.IOException -> Lcf
                            com.bytedance.sdk.openadsdk.utils.u.c(r0, r1)     // Catch: java.io.IOException -> Lcf
                        Lcb:
                            return
                        Lcc:
                            r0 = move-exception
                            monitor-exit(r1)     // Catch: java.lang.Throwable -> Lcc
                            throw r0     // Catch: java.io.IOException -> Lcf
                        Lcf:
                            r0 = move-exception
                            r0.printStackTrace()
                            goto Lcb
                        Ld4:
                            r7.delete()     // Catch: java.io.IOException -> Lcf
                            goto Lcb
                        Ld8:
                            com.bytedance.sdk.a.b.c r4 = r5.epU()     // Catch: java.lang.Throwable -> L311
                            java.io.InputStream r3 = r4.c()     // Catch: java.lang.Throwable -> L317
                            if (r3 != 0) goto L15e
                            if (r2 == 0) goto Le7
                            r6.close()     // Catch: java.io.IOException -> L150
                        Le7:
                            if (r3 == 0) goto Lec
                            r3.close()     // Catch: java.io.IOException -> L150
                        Lec:
                            if (r4 == 0) goto Lf1
                            r4.close()     // Catch: java.io.IOException -> L150
                        Lf1:
                            if (r5 == 0) goto Lf6
                            r5.close()     // Catch: java.io.IOException -> L150
                        Lf6:
                            java.util.HashSet r1 = com.bytedance.sdk.openadsdk.core.video.a.b.a.c()     // Catch: java.io.IOException -> L150
                            monitor-enter(r1)     // Catch: java.io.IOException -> L150
                            java.util.HashSet r0 = com.bytedance.sdk.openadsdk.core.video.a.b.a.c()     // Catch: java.lang.Throwable -> L156
                            com.bytedance.sdk.openadsdk.core.video.a.b.a r2 = com.bytedance.sdk.openadsdk.core.video.a.b.a.this     // Catch: java.lang.Throwable -> L156
                            java.lang.String r2 = com.bytedance.sdk.openadsdk.core.video.a.b.a.d(r2)     // Catch: java.lang.Throwable -> L156
                            r0.remove(r2)     // Catch: java.lang.Throwable -> L156
                            monitor-exit(r1)     // Catch: java.lang.Throwable -> L156
                            com.bytedance.sdk.openadsdk.core.video.a.b.a r0 = com.bytedance.sdk.openadsdk.core.video.a.b.a.this     // Catch: java.io.IOException -> L150
                            java.lang.String r0 = com.bytedance.sdk.openadsdk.core.video.a.b.a.d(r0)     // Catch: java.io.IOException -> L150
                            com.bytedance.sdk.openadsdk.core.video.a.b r0 = com.bytedance.sdk.openadsdk.core.video.a.a.a(r0)     // Catch: java.io.IOException -> L150
                            if (r0 != 0) goto L159
                            com.bytedance.sdk.openadsdk.core.video.a.b.a r0 = com.bytedance.sdk.openadsdk.core.video.a.b.a.this     // Catch: java.io.IOException -> L150
                            android.content.Context r0 = com.bytedance.sdk.openadsdk.core.video.a.b.a.c(r0)     // Catch: java.io.IOException -> L150
                            com.bytedance.sdk.openadsdk.core.video.a.b.a r1 = com.bytedance.sdk.openadsdk.core.video.a.b.a.this     // Catch: java.io.IOException -> L150
                            java.lang.String r1 = com.bytedance.sdk.openadsdk.core.video.a.b.a.d(r1)     // Catch: java.io.IOException -> L150
                            java.io.File r0 = com.bytedance.sdk.openadsdk.core.video.a.a.c.a(r0, r1)     // Catch: java.io.IOException -> L150
                            boolean r0 = r7.renameTo(r0)     // Catch: java.io.IOException -> L150
                            if (r0 != 0) goto L12e
                            r7.delete()     // Catch: java.io.IOException -> L150
                        L12e:
                            java.lang.String r0 = "VideoPreload"
                            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.io.IOException -> L150
                            r1.<init>()     // Catch: java.io.IOException -> L150
                            java.lang.String r2 = "preload success md5 = "
                            java.lang.StringBuilder r1 = r1.append(r2)     // Catch: java.io.IOException -> L150
                            com.bytedance.sdk.openadsdk.core.video.a.b.a r2 = com.bytedance.sdk.openadsdk.core.video.a.b.a.this     // Catch: java.io.IOException -> L150
                            java.lang.String r2 = com.bytedance.sdk.openadsdk.core.video.a.b.a.d(r2)     // Catch: java.io.IOException -> L150
                            java.lang.StringBuilder r1 = r1.append(r2)     // Catch: java.io.IOException -> L150
                            java.lang.String r1 = r1.toString()     // Catch: java.io.IOException -> L150
                            com.bytedance.sdk.openadsdk.utils.u.c(r0, r1)     // Catch: java.io.IOException -> L150
                            goto Lcb
                        L150:
                            r0 = move-exception
                            r0.printStackTrace()
                            goto Lcb
                        L156:
                            r0 = move-exception
                            monitor-exit(r1)     // Catch: java.lang.Throwable -> L156
                            throw r0     // Catch: java.io.IOException -> L150
                        L159:
                            r7.delete()     // Catch: java.io.IOException -> L150
                            goto Lcb
                        L15e:
                            boolean r0 = r7.exists()     // Catch: java.lang.Throwable -> L31c
                            if (r0 == 0) goto L167
                            r7.delete()     // Catch: java.lang.Throwable -> L31c
                        L167:
                            java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L31c
                            r1.<init>(r7)     // Catch: java.lang.Throwable -> L31c
                            r0 = 16384(0x4000, float:2.2959E-41)
                            byte[] r0 = new byte[r0]     // Catch: java.lang.Throwable -> L17c
                        L170:
                            int r2 = r3.read(r0)     // Catch: java.lang.Throwable -> L17c
                            r6 = -1
                            if (r2 == r6) goto L1f4
                            r6 = 0
                            r1.write(r0, r6, r2)     // Catch: java.lang.Throwable -> L17c
                            goto L170
                        L17c:
                            r0 = move-exception
                        L17d:
                            r0.printStackTrace()     // Catch: java.lang.Throwable -> L307
                            if (r1 == 0) goto L185
                            r1.close()     // Catch: java.io.IOException -> L1ee
                        L185:
                            if (r3 == 0) goto L18a
                            r3.close()     // Catch: java.io.IOException -> L1ee
                        L18a:
                            if (r4 == 0) goto L18f
                            r4.close()     // Catch: java.io.IOException -> L1ee
                        L18f:
                            if (r5 == 0) goto L194
                            r5.close()     // Catch: java.io.IOException -> L1ee
                        L194:
                            java.util.HashSet r1 = com.bytedance.sdk.openadsdk.core.video.a.b.a.c()     // Catch: java.io.IOException -> L1ee
                            monitor-enter(r1)     // Catch: java.io.IOException -> L1ee
                            java.util.HashSet r0 = com.bytedance.sdk.openadsdk.core.video.a.b.a.c()     // Catch: java.lang.Throwable -> L273
                            com.bytedance.sdk.openadsdk.core.video.a.b.a r2 = com.bytedance.sdk.openadsdk.core.video.a.b.a.this     // Catch: java.lang.Throwable -> L273
                            java.lang.String r2 = com.bytedance.sdk.openadsdk.core.video.a.b.a.d(r2)     // Catch: java.lang.Throwable -> L273
                            r0.remove(r2)     // Catch: java.lang.Throwable -> L273
                            monitor-exit(r1)     // Catch: java.lang.Throwable -> L273
                            com.bytedance.sdk.openadsdk.core.video.a.b.a r0 = com.bytedance.sdk.openadsdk.core.video.a.b.a.this     // Catch: java.io.IOException -> L1ee
                            java.lang.String r0 = com.bytedance.sdk.openadsdk.core.video.a.b.a.d(r0)     // Catch: java.io.IOException -> L1ee
                            com.bytedance.sdk.openadsdk.core.video.a.b r0 = com.bytedance.sdk.openadsdk.core.video.a.a.a(r0)     // Catch: java.io.IOException -> L1ee
                            if (r0 != 0) goto L276
                            com.bytedance.sdk.openadsdk.core.video.a.b.a r0 = com.bytedance.sdk.openadsdk.core.video.a.b.a.this     // Catch: java.io.IOException -> L1ee
                            android.content.Context r0 = com.bytedance.sdk.openadsdk.core.video.a.b.a.c(r0)     // Catch: java.io.IOException -> L1ee
                            com.bytedance.sdk.openadsdk.core.video.a.b.a r1 = com.bytedance.sdk.openadsdk.core.video.a.b.a.this     // Catch: java.io.IOException -> L1ee
                            java.lang.String r1 = com.bytedance.sdk.openadsdk.core.video.a.b.a.d(r1)     // Catch: java.io.IOException -> L1ee
                            java.io.File r0 = com.bytedance.sdk.openadsdk.core.video.a.a.c.a(r0, r1)     // Catch: java.io.IOException -> L1ee
                            boolean r0 = r7.renameTo(r0)     // Catch: java.io.IOException -> L1ee
                            if (r0 != 0) goto L1cc
                            r7.delete()     // Catch: java.io.IOException -> L1ee
                        L1cc:
                            java.lang.String r0 = "VideoPreload"
                            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.io.IOException -> L1ee
                            r1.<init>()     // Catch: java.io.IOException -> L1ee
                            java.lang.String r2 = "preload success md5 = "
                            java.lang.StringBuilder r1 = r1.append(r2)     // Catch: java.io.IOException -> L1ee
                            com.bytedance.sdk.openadsdk.core.video.a.b.a r2 = com.bytedance.sdk.openadsdk.core.video.a.b.a.this     // Catch: java.io.IOException -> L1ee
                            java.lang.String r2 = com.bytedance.sdk.openadsdk.core.video.a.b.a.d(r2)     // Catch: java.io.IOException -> L1ee
                            java.lang.StringBuilder r1 = r1.append(r2)     // Catch: java.io.IOException -> L1ee
                            java.lang.String r1 = r1.toString()     // Catch: java.io.IOException -> L1ee
                            com.bytedance.sdk.openadsdk.utils.u.c(r0, r1)     // Catch: java.io.IOException -> L1ee
                            goto Lcb
                        L1ee:
                            r0 = move-exception
                            r0.printStackTrace()
                            goto Lcb
                        L1f4:
                            r1.flush()     // Catch: java.lang.Throwable -> L17c
                            if (r1 == 0) goto L1fc
                            r1.close()     // Catch: java.io.IOException -> L265
                        L1fc:
                            if (r3 == 0) goto L201
                            r3.close()     // Catch: java.io.IOException -> L265
                        L201:
                            if (r4 == 0) goto L206
                            r4.close()     // Catch: java.io.IOException -> L265
                        L206:
                            if (r5 == 0) goto L20b
                            r5.close()     // Catch: java.io.IOException -> L265
                        L20b:
                            java.util.HashSet r1 = com.bytedance.sdk.openadsdk.core.video.a.b.a.c()     // Catch: java.io.IOException -> L265
                            monitor-enter(r1)     // Catch: java.io.IOException -> L265
                            java.util.HashSet r0 = com.bytedance.sdk.openadsdk.core.video.a.b.a.c()     // Catch: java.lang.Throwable -> L26b
                            com.bytedance.sdk.openadsdk.core.video.a.b.a r2 = com.bytedance.sdk.openadsdk.core.video.a.b.a.this     // Catch: java.lang.Throwable -> L26b
                            java.lang.String r2 = com.bytedance.sdk.openadsdk.core.video.a.b.a.d(r2)     // Catch: java.lang.Throwable -> L26b
                            r0.remove(r2)     // Catch: java.lang.Throwable -> L26b
                            monitor-exit(r1)     // Catch: java.lang.Throwable -> L26b
                            com.bytedance.sdk.openadsdk.core.video.a.b.a r0 = com.bytedance.sdk.openadsdk.core.video.a.b.a.this     // Catch: java.io.IOException -> L265
                            java.lang.String r0 = com.bytedance.sdk.openadsdk.core.video.a.b.a.d(r0)     // Catch: java.io.IOException -> L265
                            com.bytedance.sdk.openadsdk.core.video.a.b r0 = com.bytedance.sdk.openadsdk.core.video.a.a.a(r0)     // Catch: java.io.IOException -> L265
                            if (r0 != 0) goto L26e
                            com.bytedance.sdk.openadsdk.core.video.a.b.a r0 = com.bytedance.sdk.openadsdk.core.video.a.b.a.this     // Catch: java.io.IOException -> L265
                            android.content.Context r0 = com.bytedance.sdk.openadsdk.core.video.a.b.a.c(r0)     // Catch: java.io.IOException -> L265
                            com.bytedance.sdk.openadsdk.core.video.a.b.a r1 = com.bytedance.sdk.openadsdk.core.video.a.b.a.this     // Catch: java.io.IOException -> L265
                            java.lang.String r1 = com.bytedance.sdk.openadsdk.core.video.a.b.a.d(r1)     // Catch: java.io.IOException -> L265
                            java.io.File r0 = com.bytedance.sdk.openadsdk.core.video.a.a.c.a(r0, r1)     // Catch: java.io.IOException -> L265
                            boolean r0 = r7.renameTo(r0)     // Catch: java.io.IOException -> L265
                            if (r0 != 0) goto L243
                            r7.delete()     // Catch: java.io.IOException -> L265
                        L243:
                            java.lang.String r0 = "VideoPreload"
                            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.io.IOException -> L265
                            r1.<init>()     // Catch: java.io.IOException -> L265
                            java.lang.String r2 = "preload success md5 = "
                            java.lang.StringBuilder r1 = r1.append(r2)     // Catch: java.io.IOException -> L265
                            com.bytedance.sdk.openadsdk.core.video.a.b.a r2 = com.bytedance.sdk.openadsdk.core.video.a.b.a.this     // Catch: java.io.IOException -> L265
                            java.lang.String r2 = com.bytedance.sdk.openadsdk.core.video.a.b.a.d(r2)     // Catch: java.io.IOException -> L265
                            java.lang.StringBuilder r1 = r1.append(r2)     // Catch: java.io.IOException -> L265
                            java.lang.String r1 = r1.toString()     // Catch: java.io.IOException -> L265
                            com.bytedance.sdk.openadsdk.utils.u.c(r0, r1)     // Catch: java.io.IOException -> L265
                            goto Lcb
                        L265:
                            r0 = move-exception
                            r0.printStackTrace()
                            goto Lcb
                        L26b:
                            r0 = move-exception
                            monitor-exit(r1)     // Catch: java.lang.Throwable -> L26b
                            throw r0     // Catch: java.io.IOException -> L265
                        L26e:
                            r7.delete()     // Catch: java.io.IOException -> L265
                            goto Lcb
                        L273:
                            r0 = move-exception
                            monitor-exit(r1)     // Catch: java.lang.Throwable -> L273
                            throw r0     // Catch: java.io.IOException -> L1ee
                        L276:
                            r7.delete()     // Catch: java.io.IOException -> L1ee
                            goto Lcb
                        L27b:
                            r0 = move-exception
                            r1 = r2
                            r3 = r2
                            r4 = r2
                            r5 = r2
                        L280:
                            if (r1 == 0) goto L285
                            r1.close()     // Catch: java.io.IOException -> L2f0
                        L285:
                            if (r3 == 0) goto L28a
                            r3.close()     // Catch: java.io.IOException -> L2f0
                        L28a:
                            if (r4 == 0) goto L28f
                            r4.close()     // Catch: java.io.IOException -> L2f0
                        L28f:
                            if (r5 == 0) goto L294
                            r5.close()     // Catch: java.io.IOException -> L2f0
                        L294:
                            java.util.HashSet r2 = com.bytedance.sdk.openadsdk.core.video.a.b.a.c()     // Catch: java.io.IOException -> L2f0
                            monitor-enter(r2)     // Catch: java.io.IOException -> L2f0
                            java.util.HashSet r1 = com.bytedance.sdk.openadsdk.core.video.a.b.a.c()     // Catch: java.lang.Throwable -> L2ed
                            com.bytedance.sdk.openadsdk.core.video.a.b.a r3 = com.bytedance.sdk.openadsdk.core.video.a.b.a.this     // Catch: java.lang.Throwable -> L2ed
                            java.lang.String r3 = com.bytedance.sdk.openadsdk.core.video.a.b.a.d(r3)     // Catch: java.lang.Throwable -> L2ed
                            r1.remove(r3)     // Catch: java.lang.Throwable -> L2ed
                            monitor-exit(r2)     // Catch: java.lang.Throwable -> L2ed
                            com.bytedance.sdk.openadsdk.core.video.a.b.a r1 = com.bytedance.sdk.openadsdk.core.video.a.b.a.this     // Catch: java.io.IOException -> L2f0
                            java.lang.String r1 = com.bytedance.sdk.openadsdk.core.video.a.b.a.d(r1)     // Catch: java.io.IOException -> L2f0
                            com.bytedance.sdk.openadsdk.core.video.a.b r1 = com.bytedance.sdk.openadsdk.core.video.a.a.a(r1)     // Catch: java.io.IOException -> L2f0
                            if (r1 != 0) goto L2f5
                            com.bytedance.sdk.openadsdk.core.video.a.b.a r1 = com.bytedance.sdk.openadsdk.core.video.a.b.a.this     // Catch: java.io.IOException -> L2f0
                            android.content.Context r1 = com.bytedance.sdk.openadsdk.core.video.a.b.a.c(r1)     // Catch: java.io.IOException -> L2f0
                            com.bytedance.sdk.openadsdk.core.video.a.b.a r2 = com.bytedance.sdk.openadsdk.core.video.a.b.a.this     // Catch: java.io.IOException -> L2f0
                            java.lang.String r2 = com.bytedance.sdk.openadsdk.core.video.a.b.a.d(r2)     // Catch: java.io.IOException -> L2f0
                            java.io.File r1 = com.bytedance.sdk.openadsdk.core.video.a.a.c.a(r1, r2)     // Catch: java.io.IOException -> L2f0
                            boolean r1 = r7.renameTo(r1)     // Catch: java.io.IOException -> L2f0
                            if (r1 != 0) goto L2cc
                            r7.delete()     // Catch: java.io.IOException -> L2f0
                        L2cc:
                            java.lang.String r1 = "VideoPreload"
                            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.io.IOException -> L2f0
                            r2.<init>()     // Catch: java.io.IOException -> L2f0
                            java.lang.String r3 = "preload success md5 = "
                            java.lang.StringBuilder r2 = r2.append(r3)     // Catch: java.io.IOException -> L2f0
                            com.bytedance.sdk.openadsdk.core.video.a.b.a r3 = com.bytedance.sdk.openadsdk.core.video.a.b.a.this     // Catch: java.io.IOException -> L2f0
                            java.lang.String r3 = com.bytedance.sdk.openadsdk.core.video.a.b.a.d(r3)     // Catch: java.io.IOException -> L2f0
                            java.lang.StringBuilder r2 = r2.append(r3)     // Catch: java.io.IOException -> L2f0
                            java.lang.String r2 = r2.toString()     // Catch: java.io.IOException -> L2f0
                            com.bytedance.sdk.openadsdk.utils.u.c(r1, r2)     // Catch: java.io.IOException -> L2f0
                        L2ec:
                            throw r0
                        L2ed:
                            r1 = move-exception
                            monitor-exit(r2)     // Catch: java.lang.Throwable -> L2ed
                            throw r1     // Catch: java.io.IOException -> L2f0
                        L2f0:
                            r1 = move-exception
                            r1.printStackTrace()
                            goto L2ec
                        L2f5:
                            r7.delete()     // Catch: java.io.IOException -> L2f0
                            goto L2ec
                        L2f9:
                            r0 = move-exception
                            r1 = r2
                            r3 = r2
                            r4 = r2
                            goto L280
                        L2fe:
                            r0 = move-exception
                            r1 = r2
                            r3 = r2
                            goto L280
                        L303:
                            r0 = move-exception
                            r1 = r2
                            goto L280
                        L307:
                            r0 = move-exception
                            goto L280
                        L30a:
                            r0 = move-exception
                            r1 = r2
                            r3 = r2
                            r4 = r2
                            r5 = r2
                            goto L17d
                        L311:
                            r0 = move-exception
                            r1 = r2
                            r3 = r2
                            r4 = r2
                            goto L17d
                        L317:
                            r0 = move-exception
                            r1 = r2
                            r3 = r2
                            goto L17d
                        L31c:
                            r0 = move-exception
                            r1 = r2
                            goto L17d
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.video.a.b.a.AnonymousClass1.run():void");
                    }
                });
            }
        }
    }
}
