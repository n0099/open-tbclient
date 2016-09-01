package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class by implements a.b {
    private final /* synthetic */ String bVp;
    private final /* synthetic */ String bVq;
    final /* synthetic */ PbActivity eob;
    private final /* synthetic */ long eom;
    private final /* synthetic */ String eon;
    private final /* synthetic */ String eoo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public by(PbActivity pbActivity, long j, String str, String str2, String str3, String str4) {
        this.eob = pbActivity;
        this.eom = j;
        this.eon = str;
        this.bVp = str2;
        this.bVq = str3;
        this.eoo = str4;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.tieba.pb.b.a(this.eom, this.eon, null, "PB", "BTN_FBCANCEL", "CLICK_FEEDBACK", "tpoint", null, null, this.bVp, this.bVq, this.eoo);
        aVar.dismiss();
    }
}
