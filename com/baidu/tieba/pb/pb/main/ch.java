package com.baidu.tieba.pb.pb.main;

import com.baidu.tieba.pb.pb.main.cc;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ch implements Runnable {
    final /* synthetic */ cc cDC;
    private final /* synthetic */ com.baidu.tieba.pb.a.c cDG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ch(cc ccVar, com.baidu.tieba.pb.a.c cVar) {
        this.cDC = ccVar;
        this.cDG = cVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        cc.b bVar;
        this.cDC.a(this.cDG, 3, false, 0, "", false, 0, 0L, 0L, true);
        bVar = this.cDC.cDp;
        bVar.fa(true);
        this.cDC.awu = false;
    }
}
