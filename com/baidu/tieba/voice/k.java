package com.baidu.tieba.voice;
/* loaded from: classes.dex */
public class k {
    private static k e;
    private static int[] f = {8000, 11025, 16000, 22050, 32000, 44100, 47250, 48000};
    private static short[] g = {2, 3};
    private static short[] h = {2, 16, 12, 3};
    private int a;
    private short b;
    private short c;
    private int d = -2;

    public static k a() {
        k kVar;
        if (e == null) {
            synchronized (k.class) {
                if (e == null) {
                    e = new k();
                }
                kVar = e;
            }
            return kVar;
        }
        return e;
    }

    private k() {
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Found unreachable blocks
        	at jadx.core.dex.visitors.blocks.DominatorTree.sortBlocks(DominatorTree.java:35)
        	at jadx.core.dex.visitors.blocks.DominatorTree.compute(DominatorTree.java:25)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.computeDominators(BlockProcessor.java:202)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:45)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [153=6, 155=6, 156=6] */
    public final android.media.AudioRecord b() {
        /*
            r18 = this;
            r0 = r18
            int r1 = r0.a
            if (r1 <= 0) goto L29
            r0 = r18
            short r1 = r0.b
            if (r1 <= 0) goto L29
            r0 = r18
            short r1 = r0.c
            if (r1 <= 0) goto L29
            android.media.AudioRecord r1 = new android.media.AudioRecord
            r2 = 1
            r0 = r18
            int r3 = r0.a
            r0 = r18
            short r4 = r0.c
            r0 = r18
            short r5 = r0.b
            r0 = r18
            int r6 = r0.d
            r1.<init>(r2, r3, r4, r5, r6)
        L28:
            return r1
        L29:
            r2 = 0
            int[] r12 = com.baidu.tieba.voice.k.f
            int r13 = r12.length
            r1 = 0
            r9 = r1
            r1 = r2
        L30:
            if (r9 < r13) goto L3a
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.String r2 = "getInstance() failed : no suitable audio configurations on this device."
            r1.<init>(r2)
            throw r1
        L3a:
            r3 = r12[r9]
            short[] r14 = com.baidu.tieba.voice.k.g
            int r15 = r14.length
            r2 = 0
            r10 = r2
            r2 = r1
        L42:
            if (r10 < r15) goto L49
            int r1 = r9 + 1
            r9 = r1
            r1 = r2
            goto L30
        L49:
            short r5 = r14[r10]
            short[] r16 = com.baidu.tieba.voice.k.h
            r0 = r16
            int r0 = r0.length
            r17 = r0
            r1 = 0
            r11 = r1
            r7 = r2
        L55:
            r0 = r17
            if (r11 < r0) goto L5e
            int r1 = r10 + 1
            r10 = r1
            r2 = r7
            goto L42
        L5e:
            short r4 = r16[r11]
            int r1 = android.media.AudioRecord.getMinBufferSize(r3, r4, r5)     // Catch: java.lang.Throwable -> L120
            r0 = r18
            r0.d = r1     // Catch: java.lang.Throwable -> L120
            r0 = r18
            int r1 = r0.d     // Catch: java.lang.Throwable -> L120
            r2 = -2
            if (r1 != r2) goto L81
            if (r7 == 0) goto L124
            int r1 = r7.getState()
            r2 = 1
            if (r1 == r2) goto L124
            r7.release()
            r1 = 0
        L7c:
            int r2 = r11 + 1
            r11 = r2
            r7 = r1
            goto L55
        L81:
            r0 = r18
            int r1 = r0.d     // Catch: java.lang.Throwable -> L120
            int r1 = r1 * 8
            r2 = 4096(0x1000, float:5.74E-42)
            int r6 = java.lang.Math.min(r1, r2)     // Catch: java.lang.Throwable -> L120
            android.media.AudioRecord r8 = new android.media.AudioRecord     // Catch: java.lang.Throwable -> L120
            r2 = 1
            r1 = r8
            r1.<init>(r2, r3, r4, r5, r6)     // Catch: java.lang.Throwable -> L120
            int r1 = r8.getState()     // Catch: java.lang.Throwable -> Le4
            r2 = 1
            if (r1 != r2) goto Lb8
            r0 = r18
            r0.a = r3     // Catch: java.lang.Throwable -> Le4
            r0 = r18
            r0.b = r5     // Catch: java.lang.Throwable -> Le4
            r0 = r18
            r0.c = r4     // Catch: java.lang.Throwable -> Le4
            r0 = r18
            r0.d = r6     // Catch: java.lang.Throwable -> Le4
            int r1 = r8.getState()
            r2 = 1
            if (r1 == r2) goto Lb5
            r8.release()
        Lb5:
            r1 = r8
            goto L28
        Lb8:
            r8.release()     // Catch: java.lang.Throwable -> Le4
            android.media.AudioRecord r1 = new android.media.AudioRecord     // Catch: java.lang.Throwable -> Le4
            r2 = 1
            r0 = r18
            int r6 = r0.d     // Catch: java.lang.Throwable -> Le4
            r1.<init>(r2, r3, r4, r5, r6)     // Catch: java.lang.Throwable -> Le4
            int r2 = r1.getState()     // Catch: java.lang.Throwable -> L11e
            r6 = 1
            if (r2 != r6) goto L106
            r0 = r18
            r0.a = r3     // Catch: java.lang.Throwable -> L11e
            r0 = r18
            r0.b = r5     // Catch: java.lang.Throwable -> L11e
            r0 = r18
            r0.c = r4     // Catch: java.lang.Throwable -> L11e
            int r2 = r1.getState()
            r3 = 1
            if (r2 == r3) goto L28
            r1.release()
            goto L28
        Le4:
            r1 = move-exception
            r2 = r1
            r1 = r8
        Le7:
            r2.printStackTrace()     // Catch: java.lang.Throwable -> L117
            if (r1 == 0) goto L7c
            int r2 = r1.getState()
            r4 = 1
            if (r2 == r4) goto L7c
            r1.release()
            r1 = 0
            goto L7c
        Lf8:
            r1 = move-exception
        Lf9:
            if (r8 == 0) goto L105
            int r2 = r8.getState()
            r3 = 1
            if (r2 == r3) goto L105
            r8.release()
        L105:
            throw r1
        L106:
            int r2 = r1.getState()
            r4 = 1
            if (r2 == r4) goto L7c
            r1.release()
            r1 = 0
            goto L7c
        L113:
            r2 = move-exception
            r8 = r1
            r1 = r2
            goto Lf9
        L117:
            r2 = move-exception
            r8 = r1
            r1 = r2
            goto Lf9
        L11b:
            r1 = move-exception
            r8 = r7
            goto Lf9
        L11e:
            r2 = move-exception
            goto Le7
        L120:
            r1 = move-exception
            r2 = r1
            r1 = r7
            goto Le7
        L124:
            r1 = r7
            goto L7c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.tieba.voice.k.b():android.media.AudioRecord");
    }
}
