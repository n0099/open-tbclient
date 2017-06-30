package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cm implements a.b {
    private final /* synthetic */ String cfP;
    private final /* synthetic */ String cfQ;
    private final /* synthetic */ String cmM;
    final /* synthetic */ PbActivity ewh;
    private final /* synthetic */ long ewv;
    private final /* synthetic */ String eww;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cm(PbActivity pbActivity, long j, String str, String str2, String str3, String str4) {
        this.ewh = pbActivity;
        this.ewv = j;
        this.eww = str;
        this.cfP = str2;
        this.cfQ = str3;
        this.cmM = str4;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.tieba.pb.b.a(this.ewv, this.eww, null, "PB", "BTN_FBCANCEL", "CLICK_FEEDBACK", "tpoint", null, null, this.cfP, this.cfQ, this.cmM);
        aVar.dismiss();
    }
}
