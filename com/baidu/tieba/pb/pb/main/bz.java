package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bz implements a.b {
    private final /* synthetic */ String bRH;
    private final /* synthetic */ String bRI;
    private final /* synthetic */ String bZG;
    final /* synthetic */ PbActivity elO;
    private final /* synthetic */ long emc;
    private final /* synthetic */ String emd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bz(PbActivity pbActivity, long j, String str, String str2, String str3, String str4) {
        this.elO = pbActivity;
        this.emc = j;
        this.emd = str;
        this.bRH = str2;
        this.bRI = str3;
        this.bZG = str4;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.tieba.pb.b.a(this.emc, this.emd, null, "PB", "BTN_FBCANCEL", "CLICK_FEEDBACK", "tpoint", null, null, this.bRH, this.bRI, this.bZG);
        aVar.dismiss();
    }
}
