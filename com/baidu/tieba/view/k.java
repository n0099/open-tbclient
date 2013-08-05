package com.baidu.tieba.view;

import java.io.ByteArrayInputStream;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k extends Thread {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ j f1842a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar) {
        this.f1842a = jVar;
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
        w wVar;
        byte[] bArr;
        w wVar2;
        w wVar3;
        boolean z;
        w wVar4;
        w wVar5;
        try {
            j jVar = this.f1842a;
            i = this.f1842a.n;
            jVar.B = new w(i);
            try {
                try {
                    wVar = this.f1842a.B;
                    bArr = this.f1842a.m;
                    if (wVar.a(new ByteArrayInputStream(bArr)) == 0) {
                        wVar2 = this.f1842a.B;
                        if (wVar2.c != 0) {
                            wVar5 = this.f1842a.B;
                            if (wVar5.d != 0) {
                                this.f1842a.A = 1;
                                wVar3 = this.f1842a.B;
                                if (!wVar3.e()) {
                                    this.f1842a.postInvalidate();
                                }
                                this.f1842a.E = System.currentTimeMillis();
                                this.f1842a.f1841a = 2;
                                z = this.f1842a.G;
                                if (!z) {
                                    wVar4 = this.f1842a.B;
                                    if (!wVar4.a()) {
                                        this.f1842a.postInvalidate();
                                        return;
                                    }
                                    return;
                                }
                                return;
                            }
                        }
                        this.f1842a.A = 0;
                        wVar3 = this.f1842a.B;
                        if (!wVar3.e()) {
                        }
                        this.f1842a.E = System.currentTimeMillis();
                        this.f1842a.f1841a = 2;
                        z = this.f1842a.G;
                        if (!z) {
                        }
                    }
                } catch (OutOfMemoryError e) {
                    this.f1842a.c();
                }
            } catch (Exception e2) {
                this.f1842a.c();
            }
        } catch (Exception e3) {
            this.f1842a.f1841a = 0;
        }
    }
}
