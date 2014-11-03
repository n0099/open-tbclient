package com.baidu.tieba.pb.main;

import android.view.View;
/* loaded from: classes.dex */
class bb implements Runnable {
    final /* synthetic */ ba bvE;
    private final /* synthetic */ com.baidu.tieba.data.ar bvF;
    private final /* synthetic */ View bvG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bb(ba baVar, com.baidu.tieba.data.ar arVar, View view) {
        this.bvE = baVar;
        this.bvF = arVar;
        this.bvG = view;
    }

    @Override // java.lang.Runnable
    public void run() {
        PbActivity pbActivity;
        bv bvVar;
        PbActivity pbActivity2;
        bn bnVar;
        pbActivity = this.bvE.bvu;
        bvVar = pbActivity.buZ;
        com.baidu.tieba.data.ar arVar = this.bvF;
        View view = this.bvG;
        pbActivity2 = this.bvE.bvu;
        bnVar = pbActivity2.buU;
        bvVar.a(false, arVar, true, null, null, view, bnVar.getPbData().zS());
    }
}
