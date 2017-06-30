package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cl implements a.b {
    private final /* synthetic */ String cfP;
    private final /* synthetic */ String cfQ;
    private final /* synthetic */ String cmM;
    final /* synthetic */ PbActivity ewh;
    private final /* synthetic */ long ewv;
    private final /* synthetic */ String eww;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cl(PbActivity pbActivity, long j, String str, String str2, String str3, String str4) {
        this.ewh = pbActivity;
        this.ewv = j;
        this.eww = str;
        this.cfP = str2;
        this.cfQ = str3;
        this.cmM = str4;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        PbModel pbModel;
        PbModel pbModel2;
        com.baidu.tieba.pb.b.a(this.ewv, this.eww, null, "PB", "BTN_FBOK", "CLICK_FEEDBACK", "tpoint", null, null, this.cfP, this.cfQ, this.cmM);
        aVar.dismiss();
        if (this.ewh.checkUpIsLogin()) {
            pbModel = this.ewh.eue;
            if (pbModel.aPh() != null) {
                pbModel2 = this.ewh.eue;
                pbModel2.aPh().cq(this.ewv);
            }
        }
    }
}
