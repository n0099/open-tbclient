package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class br implements a.b {
    private final /* synthetic */ String ccv;
    final /* synthetic */ PbActivity djE;
    private final /* synthetic */ long djO;
    private final /* synthetic */ String djP;
    private final /* synthetic */ String djQ;
    private final /* synthetic */ String djR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public br(PbActivity pbActivity, long j, String str, String str2, String str3, String str4) {
        this.djE = pbActivity;
        this.djO = j;
        this.djP = str;
        this.ccv = str2;
        this.djQ = str3;
        this.djR = str4;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        cw cwVar;
        cw cwVar2;
        com.baidu.tieba.pb.b.a(this.djO, this.djP, null, "PB", "BTN_FBOK", "CLICK_FEEDBACK", "tpoint", this.ccv, this.djQ, this.djR);
        aVar.dismiss();
        if (this.djE.checkUpIsLogin()) {
            cwVar = this.djE.dih;
            if (cwVar.axZ() != null) {
                cwVar2 = this.djE.dih;
                cwVar2.axZ().bE(this.djO);
            }
        }
    }
}
