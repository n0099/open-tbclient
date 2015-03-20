package com.baidu.tieba.pb.pb.main;

import android.view.View;
/* loaded from: classes.dex */
class bb implements Runnable {
    final /* synthetic */ ba bIA;
    private final /* synthetic */ int bIB;
    private final /* synthetic */ com.baidu.tieba.pb.a.c bIC;
    private final /* synthetic */ View bID;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bb(ba baVar, int i, com.baidu.tieba.pb.a.c cVar, View view) {
        this.bIA = baVar;
        this.bIB = i;
        this.bIC = cVar;
        this.bID = view;
    }

    @Override // java.lang.Runnable
    public void run() {
        PbActivity pbActivity;
        bq bqVar;
        PbActivity pbActivity2;
        bq bqVar2;
        PbActivity pbActivity3;
        bq bqVar3;
        PbActivity pbActivity4;
        bq bqVar4;
        PbActivity pbActivity5;
        bq bqVar5;
        PbActivity pbActivity6;
        ci ciVar;
        PbActivity pbActivity7;
        ci ciVar2;
        PbActivity pbActivity8;
        bq bqVar6;
        pbActivity = this.bIA.bIv;
        bqVar = pbActivity.bHT;
        if (bqVar.getPbData().YQ() != null) {
            pbActivity2 = this.bIA.bIv;
            bqVar2 = pbActivity2.bHT;
            if (this.bIB <= bqVar2.getPbData().YQ().size() - 1) {
                pbActivity3 = this.bIA.bIv;
                bqVar3 = pbActivity3.bHT;
                if (bqVar3.getPbData().YQ().get(this.bIB) != null) {
                    pbActivity4 = this.bIA.bIv;
                    bqVar4 = pbActivity4.bHT;
                    if (bqVar4.getPbData().YQ().get(this.bIB).amI()) {
                        pbActivity7 = this.bIA.bIv;
                        ciVar2 = pbActivity7.bHY;
                        com.baidu.tieba.pb.a.c cVar = this.bIC;
                        View view = this.bID;
                        pbActivity8 = this.bIA.bIv;
                        bqVar6 = pbActivity8.bHT;
                        ciVar2.a(false, cVar, true, null, null, view, bqVar6.getPbData().YS());
                        return;
                    }
                    pbActivity5 = this.bIA.bIv;
                    bqVar5 = pbActivity5.bHT;
                    bqVar5.getPbData().YQ().get(this.bIB).eP(true);
                    pbActivity6 = this.bIA.bIv;
                    ciVar = pbActivity6.bHY;
                    ciVar.aaE().notifyDataSetChanged();
                }
            }
        }
    }
}
