package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bd implements a.b {
    final /* synthetic */ PbActivity cFS;
    private final /* synthetic */ long cGb;
    private final /* synthetic */ String cGc;
    private final /* synthetic */ String cGd;
    private final /* synthetic */ String cGe;
    private final /* synthetic */ String cGf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bd(PbActivity pbActivity, long j, String str, String str2, String str3, String str4) {
        this.cFS = pbActivity;
        this.cGb = j;
        this.cGc = str;
        this.cGd = str2;
        this.cGe = str3;
        this.cGf = str4;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        cf cfVar;
        com.baidu.tieba.pb.a.a(this.cGb, this.cGc, null, "PB", "BTN_FBOK", "CLICK_FEEDBACK", "tpoint", this.cGd, this.cGe, this.cGf);
        aVar.dismiss();
        if (this.cFS.checkUpIsLogin()) {
            cfVar = this.cFS.cFl;
            cfVar.bl(this.cGb);
        }
    }
}
