package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bw implements a.b {
    private final /* synthetic */ String bRw;
    private final /* synthetic */ String bRx;
    private final /* synthetic */ String bYf;
    final /* synthetic */ PbActivity ejU;
    private final /* synthetic */ long eki;
    private final /* synthetic */ String ekj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bw(PbActivity pbActivity, long j, String str, String str2, String str3, String str4) {
        this.ejU = pbActivity;
        this.eki = j;
        this.ekj = str;
        this.bRw = str2;
        this.bRx = str3;
        this.bYf = str4;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        PbModel pbModel;
        PbModel pbModel2;
        com.baidu.tieba.pb.b.a(this.eki, this.ekj, null, "PB", "BTN_FBOK", "CLICK_FEEDBACK", "tpoint", null, null, this.bRw, this.bRx, this.bYf);
        aVar.dismiss();
        if (this.ejU.checkUpIsLogin()) {
            pbModel = this.ejU.eif;
            if (pbModel.aMa() != null) {
                pbModel2 = this.ejU.eif;
                pbModel2.aMa().cm(this.eki);
            }
        }
    }
}
