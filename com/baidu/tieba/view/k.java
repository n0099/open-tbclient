package com.baidu.tieba.view;

import java.io.ByteArrayInputStream;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k extends Thread {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ j f1871a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar) {
        this.f1871a = jVar;
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
        ad adVar;
        byte[] bArr;
        ad adVar2;
        ad adVar3;
        boolean z;
        ad adVar4;
        ad adVar5;
        try {
            j jVar = this.f1871a;
            i = this.f1871a.n;
            jVar.B = new ad(i);
            try {
                try {
                    adVar = this.f1871a.B;
                    bArr = this.f1871a.m;
                    if (adVar.a(new ByteArrayInputStream(bArr)) == 0) {
                        adVar2 = this.f1871a.B;
                        if (adVar2.c != 0) {
                            adVar5 = this.f1871a.B;
                            if (adVar5.d != 0) {
                                this.f1871a.A = 1;
                                adVar3 = this.f1871a.B;
                                if (!adVar3.e()) {
                                    this.f1871a.postInvalidate();
                                }
                                this.f1871a.E = System.currentTimeMillis();
                                this.f1871a.f1870a = 2;
                                z = this.f1871a.G;
                                if (!z) {
                                    adVar4 = this.f1871a.B;
                                    if (!adVar4.a()) {
                                        this.f1871a.postInvalidate();
                                        return;
                                    }
                                    return;
                                }
                                return;
                            }
                        }
                        this.f1871a.A = 0;
                        adVar3 = this.f1871a.B;
                        if (!adVar3.e()) {
                        }
                        this.f1871a.E = System.currentTimeMillis();
                        this.f1871a.f1870a = 2;
                        z = this.f1871a.G;
                        if (!z) {
                        }
                    }
                } catch (OutOfMemoryError e) {
                    this.f1871a.c();
                }
            } catch (Exception e2) {
                this.f1871a.c();
            }
        } catch (Exception e3) {
            this.f1871a.f1870a = 0;
        }
    }
}
