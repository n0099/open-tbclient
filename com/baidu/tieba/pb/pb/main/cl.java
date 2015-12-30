package com.baidu.tieba.pb.pb.main;

import com.baidu.tieba.pb.pb.main.cf;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cl implements Runnable {
    final /* synthetic */ cf cHv;
    private final /* synthetic */ com.baidu.tieba.pb.a.c cHz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cl(cf cfVar, com.baidu.tieba.pb.a.c cVar) {
        this.cHv = cfVar;
        this.cHz = cVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        cf.c cVar;
        this.cHv.a(this.cHz, 3, false, 0, "", false, 0, 0L, 0L, true);
        cVar = this.cHv.cHf;
        cVar.eZ(true);
        this.cHv.axY = false;
    }
}
