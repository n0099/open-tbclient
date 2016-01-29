package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bl implements a.b {
    private final /* synthetic */ String cNA;
    private final /* synthetic */ String cNB;
    private final /* synthetic */ String cNC;
    private final /* synthetic */ String cND;
    final /* synthetic */ PbActivity cNq;
    private final /* synthetic */ long cNz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bl(PbActivity pbActivity, long j, String str, String str2, String str3, String str4) {
        this.cNq = pbActivity;
        this.cNz = j;
        this.cNA = str;
        this.cNB = str2;
        this.cNC = str3;
        this.cND = str4;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        cm cmVar;
        com.baidu.tieba.pb.a.a(this.cNz, this.cNA, null, "PB", "BTN_FBOK", "CLICK_FEEDBACK", "tpoint", this.cNB, this.cNC, this.cND);
        aVar.dismiss();
        if (this.cNq.checkUpIsLogin()) {
            cmVar = this.cNq.cMF;
            cmVar.bn(this.cNz);
        }
    }
}
