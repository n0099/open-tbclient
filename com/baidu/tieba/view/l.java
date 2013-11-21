package com.baidu.tieba.view;

import java.io.ByteArrayInputStream;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l extends Thread {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ k f2574a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(k kVar) {
        this.f2574a = kVar;
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
        ae aeVar;
        byte[] bArr;
        ae aeVar2;
        ae aeVar3;
        boolean z;
        ae aeVar4;
        ae aeVar5;
        try {
            k kVar = this.f2574a;
            i = this.f2574a.n;
            kVar.B = new ae(i);
            try {
                aeVar = this.f2574a.B;
                bArr = this.f2574a.m;
                if (aeVar.a(new ByteArrayInputStream(bArr)) == 0) {
                    aeVar2 = this.f2574a.B;
                    if (aeVar2.c != 0) {
                        aeVar5 = this.f2574a.B;
                        if (aeVar5.d != 0) {
                            this.f2574a.A = 1;
                            aeVar3 = this.f2574a.B;
                            if (!aeVar3.e()) {
                                this.f2574a.postInvalidate();
                            }
                            this.f2574a.E = System.currentTimeMillis();
                            this.f2574a.f2573a = 2;
                            z = this.f2574a.G;
                            if (!z) {
                                aeVar4 = this.f2574a.B;
                                if (!aeVar4.a()) {
                                    this.f2574a.postInvalidate();
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                    }
                    this.f2574a.A = 0;
                    aeVar3 = this.f2574a.B;
                    if (!aeVar3.e()) {
                    }
                    this.f2574a.E = System.currentTimeMillis();
                    this.f2574a.f2573a = 2;
                    z = this.f2574a.G;
                    if (!z) {
                    }
                }
            } catch (Exception e) {
                this.f2574a.c();
            } catch (OutOfMemoryError e2) {
                this.f2574a.c();
            }
        } catch (Exception e3) {
            this.f2574a.f2573a = 0;
        }
    }
}
