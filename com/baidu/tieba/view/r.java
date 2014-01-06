package com.baidu.tieba.view;

import java.io.ByteArrayInputStream;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r extends Thread {
    final /* synthetic */ q a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(q qVar) {
        this.a = qVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0064 A[Catch: Exception -> 0x0031, TryCatch #2 {Exception -> 0x0031, blocks: (B:3:0x0002, B:14:0x003e, B:16:0x0048, B:27:0x0091, B:19:0x0058, B:21:0x0064, B:22:0x0069, B:24:0x007f, B:26:0x008b, B:18:0x0052, B:8:0x002b, B:13:0x0038, B:4:0x0012), top: B:29:0x0002, inners: #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x007f A[Catch: Exception -> 0x0031, TryCatch #2 {Exception -> 0x0031, blocks: (B:3:0x0002, B:14:0x003e, B:16:0x0048, B:27:0x0091, B:19:0x0058, B:21:0x0064, B:22:0x0069, B:24:0x007f, B:26:0x008b, B:18:0x0052, B:8:0x002b, B:13:0x0038, B:4:0x0012), top: B:29:0x0002, inners: #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:34:? A[RETURN, SYNTHETIC] */
    @Override // java.lang.Thread, java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run() {
        int i;
        ak akVar;
        byte[] bArr;
        ak akVar2;
        ak akVar3;
        boolean z;
        ak akVar4;
        ak akVar5;
        try {
            q qVar = this.a;
            i = this.a.n;
            qVar.C = new ak(i);
            try {
                akVar = this.a.C;
                bArr = this.a.m;
                if (akVar.a(new ByteArrayInputStream(bArr)) == 0) {
                    akVar2 = this.a.C;
                    if (akVar2.c != 0) {
                        akVar5 = this.a.C;
                        if (akVar5.d != 0) {
                            this.a.B = 1;
                            akVar3 = this.a.C;
                            if (!akVar3.e()) {
                                this.a.postInvalidate();
                            }
                            this.a.F = System.currentTimeMillis();
                            this.a.a = 2;
                            z = this.a.H;
                            if (!z) {
                                akVar4 = this.a.C;
                                if (!akVar4.a()) {
                                    this.a.postInvalidate();
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                    }
                    this.a.B = 0;
                    akVar3 = this.a.C;
                    if (!akVar3.e()) {
                    }
                    this.a.F = System.currentTimeMillis();
                    this.a.a = 2;
                    z = this.a.H;
                    if (!z) {
                    }
                }
            } catch (Exception e) {
                this.a.c();
            } catch (OutOfMemoryError e2) {
                this.a.c();
            }
        } catch (Exception e3) {
            this.a.a = 0;
        }
    }
}
