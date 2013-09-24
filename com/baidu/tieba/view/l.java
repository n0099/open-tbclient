package com.baidu.tieba.view;

import java.io.ByteArrayInputStream;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l extends Thread {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ k f2000a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(k kVar) {
        this.f2000a = kVar;
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
        ae aeVar;
        byte[] bArr;
        ae aeVar2;
        ae aeVar3;
        boolean z;
        ae aeVar4;
        ae aeVar5;
        try {
            k kVar = this.f2000a;
            i = this.f2000a.n;
            kVar.B = new ae(i);
            try {
                try {
                    aeVar = this.f2000a.B;
                    bArr = this.f2000a.m;
                    if (aeVar.a(new ByteArrayInputStream(bArr)) == 0) {
                        aeVar2 = this.f2000a.B;
                        if (aeVar2.c != 0) {
                            aeVar5 = this.f2000a.B;
                            if (aeVar5.d != 0) {
                                this.f2000a.A = 1;
                                aeVar3 = this.f2000a.B;
                                if (!aeVar3.e()) {
                                    this.f2000a.postInvalidate();
                                }
                                this.f2000a.E = System.currentTimeMillis();
                                this.f2000a.f1999a = 2;
                                z = this.f2000a.G;
                                if (!z) {
                                    aeVar4 = this.f2000a.B;
                                    if (!aeVar4.a()) {
                                        this.f2000a.postInvalidate();
                                        return;
                                    }
                                    return;
                                }
                                return;
                            }
                        }
                        this.f2000a.A = 0;
                        aeVar3 = this.f2000a.B;
                        if (!aeVar3.e()) {
                        }
                        this.f2000a.E = System.currentTimeMillis();
                        this.f2000a.f1999a = 2;
                        z = this.f2000a.G;
                        if (!z) {
                        }
                    }
                } catch (OutOfMemoryError e) {
                    this.f2000a.c();
                }
            } catch (Exception e2) {
                this.f2000a.c();
            }
        } catch (Exception e3) {
            this.f2000a.f1999a = 0;
        }
    }
}
