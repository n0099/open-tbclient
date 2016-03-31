package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ci implements a.b {
    private final /* synthetic */ String cbQ;
    private final /* synthetic */ long dhF;
    private final /* synthetic */ String dhG;
    private final /* synthetic */ String dhH;
    private final /* synthetic */ String dhI;
    final /* synthetic */ PbActivity dht;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ci(PbActivity pbActivity, long j, String str, String str2, String str3, String str4) {
        this.dht = pbActivity;
        this.dhF = j;
        this.dhG = str;
        this.cbQ = str2;
        this.dhH = str3;
        this.dhI = str4;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        df dfVar;
        com.baidu.tieba.pb.b.a(this.dhF, this.dhG, null, "PB", "BTN_FBOK", "CLICK_FEEDBACK", "tpoint", this.cbQ, this.dhH, this.dhI);
        aVar.dismiss();
        if (this.dht.checkUpIsLogin()) {
            dfVar = this.dht.dfV;
            dfVar.bE(this.dhF);
        }
    }
}
