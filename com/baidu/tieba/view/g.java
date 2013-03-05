package com.baidu.tieba.view;

import java.io.ByteArrayInputStream;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g extends Thread {
    final /* synthetic */ f a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(f fVar) {
        this.a = fVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x004f A[Catch: Exception -> 0x007c, TryCatch #0 {Exception -> 0x007c, blocks: (B:3:0x0001, B:6:0x0029, B:8:0x0033, B:22:0x0082, B:11:0x0043, B:13:0x004f, B:14:0x0054, B:16:0x006a, B:18:0x0076, B:10:0x003d), top: B:24:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x006a A[Catch: Exception -> 0x007c, TryCatch #0 {Exception -> 0x007c, blocks: (B:3:0x0001, B:6:0x0029, B:8:0x0033, B:22:0x0082, B:11:0x0043, B:13:0x004f, B:14:0x0054, B:16:0x006a, B:18:0x0076, B:10:0x003d), top: B:24:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
    @Override // java.lang.Thread, java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run() {
        int i;
        r rVar;
        byte[] bArr;
        r rVar2;
        r rVar3;
        boolean z;
        r rVar4;
        r rVar5;
        try {
            f fVar = this.a;
            i = this.a.n;
            fVar.B = new r(i);
            rVar = this.a.B;
            bArr = this.a.m;
            if (rVar.a(new ByteArrayInputStream(bArr)) == 0) {
                rVar2 = this.a.B;
                if (rVar2.c != 0) {
                    rVar5 = this.a.B;
                    if (rVar5.d != 0) {
                        this.a.A = 1;
                        rVar3 = this.a.B;
                        if (!rVar3.e()) {
                            this.a.postInvalidate();
                        }
                        this.a.E = System.currentTimeMillis();
                        this.a.a = 2;
                        z = this.a.G;
                        if (!z) {
                            rVar4 = this.a.B;
                            if (!rVar4.a()) {
                                this.a.postInvalidate();
                                return;
                            }
                            return;
                        }
                        return;
                    }
                }
                this.a.A = 0;
                rVar3 = this.a.B;
                if (!rVar3.e()) {
                }
                this.a.E = System.currentTimeMillis();
                this.a.a = 2;
                z = this.a.G;
                if (!z) {
                }
            }
        } catch (Exception e) {
            this.a.a = 0;
        }
    }
}
