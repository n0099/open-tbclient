package com.baidu.tieba.pb.pb.main;

import com.baidu.tieba.pb.pb.main.cm;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cs implements Runnable {
    final /* synthetic */ cm cPd;
    private final /* synthetic */ com.baidu.tieba.pb.a.c cPh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cs(cm cmVar, com.baidu.tieba.pb.a.c cVar) {
        this.cPd = cmVar;
        this.cPh = cVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        cm.c cVar;
        this.cPd.a(this.cPh, 3, false, 0, "", false, 0, 0L, 0L, true);
        cVar = this.cPd.cOL;
        cVar.fo(true);
        this.cPd.ayQ = false;
    }
}
