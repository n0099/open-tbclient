package com.baidu.tieba.pb.main;

import android.view.View;
/* loaded from: classes.dex */
class bb implements Runnable {
    final /* synthetic */ ba bvq;
    private final /* synthetic */ com.baidu.tieba.data.ar bvr;
    private final /* synthetic */ View bvs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bb(ba baVar, com.baidu.tieba.data.ar arVar, View view) {
        this.bvq = baVar;
        this.bvr = arVar;
        this.bvs = view;
    }

    @Override // java.lang.Runnable
    public void run() {
        PbActivity pbActivity;
        bv bvVar;
        PbActivity pbActivity2;
        bn bnVar;
        pbActivity = this.bvq.bvg;
        bvVar = pbActivity.buL;
        com.baidu.tieba.data.ar arVar = this.bvr;
        View view = this.bvs;
        pbActivity2 = this.bvq.bvg;
        bnVar = pbActivity2.buG;
        bvVar.a(false, arVar, true, null, null, view, bnVar.getPbData().zQ());
    }
}
