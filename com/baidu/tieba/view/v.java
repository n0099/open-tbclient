package com.baidu.tieba.view;

import java.io.ByteArrayInputStream;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v extends Thread {
    final /* synthetic */ u a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(u uVar) {
        this.a = uVar;
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
        as asVar;
        byte[] bArr;
        as asVar2;
        as asVar3;
        boolean z;
        as asVar4;
        as asVar5;
        try {
            u uVar = this.a;
            i = this.a.n;
            uVar.C = new as(i);
            try {
                asVar = this.a.C;
                bArr = this.a.m;
                if (asVar.a(new ByteArrayInputStream(bArr)) == 0) {
                    asVar2 = this.a.C;
                    if (asVar2.c != 0) {
                        asVar5 = this.a.C;
                        if (asVar5.d != 0) {
                            this.a.B = 1;
                            asVar3 = this.a.C;
                            if (!asVar3.e()) {
                                this.a.postInvalidate();
                            }
                            this.a.F = System.currentTimeMillis();
                            this.a.a = 2;
                            z = this.a.H;
                            if (!z) {
                                asVar4 = this.a.C;
                                if (!asVar4.a()) {
                                    this.a.postInvalidate();
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                    }
                    this.a.B = 0;
                    asVar3 = this.a.C;
                    if (!asVar3.e()) {
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
