package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bx implements a.b {
    private final /* synthetic */ String bTN;
    private final /* synthetic */ String bTO;
    private final /* synthetic */ String caw;
    final /* synthetic */ PbActivity emk;
    private final /* synthetic */ long emy;
    private final /* synthetic */ String emz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bx(PbActivity pbActivity, long j, String str, String str2, String str3, String str4) {
        this.emk = pbActivity;
        this.emy = j;
        this.emz = str;
        this.bTN = str2;
        this.bTO = str3;
        this.caw = str4;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.tieba.pb.b.a(this.emy, this.emz, null, "PB", "BTN_FBCANCEL", "CLICK_FEEDBACK", "tpoint", null, null, this.bTN, this.bTO, this.caw);
        aVar.dismiss();
    }
}
