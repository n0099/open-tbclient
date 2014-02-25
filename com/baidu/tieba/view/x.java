package com.baidu.tieba.view;

import java.io.ByteArrayInputStream;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x extends Thread {
    final /* synthetic */ w a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(w wVar) {
        this.a = wVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0063 A[Catch: Exception -> 0x0030, TryCatch #0 {Exception -> 0x0030, blocks: (B:3:0x0001, B:14:0x003d, B:16:0x0047, B:27:0x0090, B:19:0x0057, B:21:0x0063, B:22:0x0068, B:24:0x007e, B:26:0x008a, B:18:0x0051, B:8:0x002a, B:13:0x0037, B:4:0x0011), top: B:29:0x0001, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x007e A[Catch: Exception -> 0x0030, TryCatch #0 {Exception -> 0x0030, blocks: (B:3:0x0001, B:14:0x003d, B:16:0x0047, B:27:0x0090, B:19:0x0057, B:21:0x0063, B:22:0x0068, B:24:0x007e, B:26:0x008a, B:18:0x0051, B:8:0x002a, B:13:0x0037, B:4:0x0011), top: B:29:0x0001, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:34:? A[RETURN, SYNTHETIC] */
    @Override // java.lang.Thread, java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run() {
        int i;
        aw awVar;
        byte[] bArr;
        aw awVar2;
        aw awVar3;
        boolean z;
        aw awVar4;
        aw awVar5;
        try {
            w wVar = this.a;
            i = this.a.n;
            wVar.C = new aw(i);
            try {
                try {
                    awVar = this.a.C;
                    bArr = this.a.m;
                    if (awVar.a(new ByteArrayInputStream(bArr)) == 0) {
                        awVar2 = this.a.C;
                        if (awVar2.c != 0) {
                            awVar5 = this.a.C;
                            if (awVar5.d != 0) {
                                this.a.B = 1;
                                awVar3 = this.a.C;
                                if (!awVar3.e()) {
                                    this.a.postInvalidate();
                                }
                                this.a.F = System.currentTimeMillis();
                                this.a.a = 2;
                                z = this.a.H;
                                if (!z) {
                                    awVar4 = this.a.C;
                                    if (!awVar4.a()) {
                                        this.a.postInvalidate();
                                        return;
                                    }
                                    return;
                                }
                                return;
                            }
                        }
                        this.a.B = 0;
                        awVar3 = this.a.C;
                        if (!awVar3.e()) {
                        }
                        this.a.F = System.currentTimeMillis();
                        this.a.a = 2;
                        z = this.a.H;
                        if (!z) {
                        }
                    }
                } catch (OutOfMemoryError e) {
                    this.a.c();
                }
            } catch (Exception e2) {
                this.a.c();
            }
        } catch (Exception e3) {
            this.a.a = 0;
        }
    }
}
