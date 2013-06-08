package com.baidu.tieba.view;

import java.io.ByteArrayInputStream;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i extends Thread {
    final /* synthetic */ h a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar) {
        this.a = hVar;
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
        u uVar;
        byte[] bArr;
        u uVar2;
        u uVar3;
        boolean z;
        u uVar4;
        u uVar5;
        try {
            h hVar = this.a;
            i = this.a.n;
            hVar.B = new u(i);
            try {
                try {
                    uVar = this.a.B;
                    bArr = this.a.m;
                    if (uVar.a(new ByteArrayInputStream(bArr)) == 0) {
                        uVar2 = this.a.B;
                        if (uVar2.c != 0) {
                            uVar5 = this.a.B;
                            if (uVar5.d != 0) {
                                this.a.A = 1;
                                uVar3 = this.a.B;
                                if (!uVar3.e()) {
                                    this.a.postInvalidate();
                                }
                                this.a.E = System.currentTimeMillis();
                                this.a.a = 2;
                                z = this.a.G;
                                if (!z) {
                                    uVar4 = this.a.B;
                                    if (!uVar4.a()) {
                                        this.a.postInvalidate();
                                        return;
                                    }
                                    return;
                                }
                                return;
                            }
                        }
                        this.a.A = 0;
                        uVar3 = this.a.B;
                        if (!uVar3.e()) {
                        }
                        this.a.E = System.currentTimeMillis();
                        this.a.a = 2;
                        z = this.a.G;
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
