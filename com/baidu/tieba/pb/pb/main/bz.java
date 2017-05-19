package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bz implements a.b {
    private final /* synthetic */ String bRP;
    private final /* synthetic */ String bRQ;
    private final /* synthetic */ String bYo;
    private final /* synthetic */ long ehM;
    private final /* synthetic */ String ehN;
    final /* synthetic */ PbActivity ehy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bz(PbActivity pbActivity, long j, String str, String str2, String str3, String str4) {
        this.ehy = pbActivity;
        this.ehM = j;
        this.ehN = str;
        this.bRP = str2;
        this.bRQ = str3;
        this.bYo = str4;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        PbModel pbModel;
        PbModel pbModel2;
        com.baidu.tieba.pb.b.a(this.ehM, this.ehN, null, "PB", "BTN_FBOK", "CLICK_FEEDBACK", "tpoint", null, null, this.bRP, this.bRQ, this.bYo);
        aVar.dismiss();
        if (this.ehy.checkUpIsLogin()) {
            pbModel = this.ehy.efE;
            if (pbModel.aKq() != null) {
                pbModel2 = this.ehy.efE;
                pbModel2.aKq().bX(this.ehM);
            }
        }
    }
}
