package com.baidu.tieba.view;

import java.io.ByteArrayInputStream;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h extends Thread {
    final /* synthetic */ g a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar) {
        this.a = gVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x004f A[Catch: Exception -> 0x007c, TryCatch #0 {Exception -> 0x007c, blocks: (B:3:0x0001, B:7:0x0029, B:9:0x0033, B:23:0x0082, B:12:0x0043, B:14:0x004f, B:15:0x0054, B:17:0x006a, B:19:0x0076, B:11:0x003d), top: B:27:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x006a A[Catch: Exception -> 0x007c, TryCatch #0 {Exception -> 0x007c, blocks: (B:3:0x0001, B:7:0x0029, B:9:0x0033, B:23:0x0082, B:12:0x0043, B:14:0x004f, B:15:0x0054, B:17:0x006a, B:19:0x0076, B:11:0x003d), top: B:27:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:31:? A[RETURN, SYNTHETIC] */
    @Override // java.lang.Thread, java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run() {
        int i;
        t tVar;
        byte[] bArr;
        t tVar2;
        t tVar3;
        boolean z;
        t tVar4;
        t tVar5;
        try {
            g gVar = this.a;
            i = this.a.n;
            gVar.B = new t(i);
            try {
                tVar = this.a.B;
                bArr = this.a.m;
                if (tVar.a(new ByteArrayInputStream(bArr)) == 0) {
                    tVar2 = this.a.B;
                    if (tVar2.c != 0) {
                        tVar5 = this.a.B;
                        if (tVar5.d != 0) {
                            this.a.A = 1;
                            tVar3 = this.a.B;
                            if (!tVar3.e()) {
                                this.a.postInvalidate();
                            }
                            this.a.E = System.currentTimeMillis();
                            this.a.a = 2;
                            z = this.a.G;
                            if (!z) {
                                tVar4 = this.a.B;
                                if (!tVar4.a()) {
                                    this.a.postInvalidate();
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                    }
                    this.a.A = 0;
                    tVar3 = this.a.B;
                    if (!tVar3.e()) {
                    }
                    this.a.E = System.currentTimeMillis();
                    this.a.a = 2;
                    z = this.a.G;
                    if (!z) {
                    }
                }
            } catch (Exception e) {
            }
        } catch (Exception e2) {
            this.a.a = 0;
        }
    }
}
