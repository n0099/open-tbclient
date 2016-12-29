package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class by implements a.b {
    private final /* synthetic */ String bDo;
    private final /* synthetic */ String bEe;
    final /* synthetic */ PbActivity eah;
    private final /* synthetic */ long eau;
    private final /* synthetic */ String eav;
    private final /* synthetic */ String eaw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public by(PbActivity pbActivity, long j, String str, String str2, String str3, String str4) {
        this.eah = pbActivity;
        this.eau = j;
        this.eav = str;
        this.bDo = str2;
        this.bEe = str3;
        this.eaw = str4;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.tieba.pb.b.a(this.eau, this.eav, null, "PB", "BTN_FBCANCEL", "CLICK_FEEDBACK", "tpoint", null, null, this.bDo, this.bEe, this.eaw);
        aVar.dismiss();
    }
}
