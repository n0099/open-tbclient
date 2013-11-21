package com.baidu.tieba.voice;
/* loaded from: classes.dex */
public class k {
    private static k e;
    private static int[] f = {8000, 11025, 16000, 22050, 32000, 44100, 47250, 48000};
    private static short[] g = {2, 3};
    private static short[] h = {2, 16, 12, 3};

    /* renamed from: a  reason: collision with root package name */
    private int f2611a;
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
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [149=8, 151=6] */
    public android.media.AudioRecord b() {
        /*
            r18 = this;
            r0 = r18
            int r1 = r0.f2611a
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
            int r3 = r0.f2611a
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
            if (r9 >= r13) goto L101
            r3 = r12[r9]
            short[] r14 = com.baidu.tieba.voice.k.g
            int r15 = r14.length
            r2 = 0
            r10 = r2
            r2 = r1
        L3a:
            if (r10 >= r15) goto Lfb
            short r5 = r14[r10]
            short[] r16 = com.baidu.tieba.voice.k.h
            r0 = r16
            int r0 = r0.length
            r17 = r0
            r1 = 0
            r11 = r1
            r8 = r2
        L48:
            r0 = r17
            if (r11 >= r0) goto Lf5
            short r4 = r16[r11]
            int r1 = android.media.AudioRecord.getMinBufferSize(r3, r4, r5)     // Catch: java.lang.Throwable -> L123
            r0 = r18
            r0.d = r1     // Catch: java.lang.Throwable -> L123
            r0 = r18
            int r1 = r0.d     // Catch: java.lang.Throwable -> L123
            r2 = -2
            if (r1 != r2) goto L70
            if (r8 == 0) goto L126
            int r1 = r8.getState()
            r2 = 1
            if (r1 == r2) goto L126
            r8.release()
            r8 = 0
            r1 = r8
        L6b:
            int r2 = r11 + 1
            r11 = r2
            r8 = r1
            goto L48
        L70:
            android.media.AudioRecord r7 = new android.media.AudioRecord     // Catch: java.lang.Throwable -> L123
            r2 = 1
            r0 = r18
            int r6 = r0.d     // Catch: java.lang.Throwable -> L123
            r1 = r7
            r1.<init>(r2, r3, r4, r5, r6)     // Catch: java.lang.Throwable -> L123
            int r1 = r7.getState()     // Catch: java.lang.Throwable -> Ld4
            r2 = 1
            if (r1 != r2) goto L9c
            r0 = r18
            r0.f2611a = r3     // Catch: java.lang.Throwable -> Ld4
            r0 = r18
            r0.b = r5     // Catch: java.lang.Throwable -> Ld4
            r0 = r18
            r0.c = r4     // Catch: java.lang.Throwable -> Ld4
            if (r7 == 0) goto L9a
            int r1 = r7.getState()
            r2 = 1
            if (r1 == r2) goto L9a
            r7.release()
        L9a:
            r1 = r7
            goto L28
        L9c:
            r7.release()     // Catch: java.lang.Throwable -> Ld4
            r0 = r18
            int r1 = r0.d     // Catch: java.lang.Throwable -> Ld4
            int r1 = r1 + 100
            r0 = r18
            r0.d = r1     // Catch: java.lang.Throwable -> Ld4
            android.media.AudioRecord r1 = new android.media.AudioRecord     // Catch: java.lang.Throwable -> Ld4
            r2 = 1
            r0 = r18
            int r6 = r0.d     // Catch: java.lang.Throwable -> Ld4
            r1.<init>(r2, r3, r4, r5, r6)     // Catch: java.lang.Throwable -> Ld4
            int r2 = r1.getState()     // Catch: java.lang.Throwable -> L11f
            r6 = 1
            if (r2 != r6) goto L109
            r0 = r18
            r0.f2611a = r3     // Catch: java.lang.Throwable -> L11f
            r0 = r18
            r0.b = r5     // Catch: java.lang.Throwable -> L11f
            r0 = r18
            r0.c = r4     // Catch: java.lang.Throwable -> L11f
            if (r1 == 0) goto L28
            int r2 = r1.getState()
            r3 = 1
            if (r2 == r3) goto L28
            r1.release()
            goto L28
        Ld4:
            r1 = move-exception
        Ld5:
            r1.printStackTrace()     // Catch: java.lang.Throwable -> Le7
            if (r7 == 0) goto L129
            int r1 = r7.getState()
            r2 = 1
            if (r1 == r2) goto L129
            r7.release()
            r7 = 0
            r1 = r7
            goto L6b
        Le7:
            r1 = move-exception
        Le8:
            if (r7 == 0) goto Lf4
            int r2 = r7.getState()
            r3 = 1
            if (r2 == r3) goto Lf4
            r7.release()
        Lf4:
            throw r1
        Lf5:
            int r1 = r10 + 1
            r10 = r1
            r2 = r8
            goto L3a
        Lfb:
            int r1 = r9 + 1
            r9 = r1
            r1 = r2
            goto L30
        L101:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.String r2 = "getInstance() failed : no suitable audio configurations on this device."
            r1.<init>(r2)
            throw r1
        L109:
            if (r1 == 0) goto L6b
            int r2 = r1.getState()
            r4 = 1
            if (r2 == r4) goto L6b
            r1.release()
            r1 = 0
            goto L6b
        L118:
            r2 = move-exception
            r7 = r1
            r1 = r2
            goto Le8
        L11c:
            r1 = move-exception
            r7 = r8
            goto Le8
        L11f:
            r2 = move-exception
            r7 = r1
            r1 = r2
            goto Ld5
        L123:
            r1 = move-exception
            r7 = r8
            goto Ld5
        L126:
            r1 = r8
            goto L6b
        L129:
            r1 = r7
            goto L6b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.tieba.voice.k.b():android.media.AudioRecord");
    }
}
