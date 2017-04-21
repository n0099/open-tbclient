package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bw implements a.b {
    private final /* synthetic */ String bTN;
    private final /* synthetic */ String bTO;
    private final /* synthetic */ String caw;
    final /* synthetic */ PbActivity emk;
    private final /* synthetic */ long emy;
    private final /* synthetic */ String emz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bw(PbActivity pbActivity, long j, String str, String str2, String str3, String str4) {
        this.emk = pbActivity;
        this.emy = j;
        this.emz = str;
        this.bTN = str2;
        this.bTO = str3;
        this.caw = str4;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        PbModel pbModel;
        PbModel pbModel2;
        com.baidu.tieba.pb.b.a(this.emy, this.emz, null, "PB", "BTN_FBOK", "CLICK_FEEDBACK", "tpoint", null, null, this.bTN, this.bTO, this.caw);
        aVar.dismiss();
        if (this.emk.checkUpIsLogin()) {
            pbModel = this.emk.ekv;
            if (pbModel.aNb() != null) {
                pbModel2 = this.emk.ekv;
                pbModel2.aNb().cm(this.emy);
            }
        }
    }
}
