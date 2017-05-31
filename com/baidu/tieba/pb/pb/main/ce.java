package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ce implements a.b {
    private final /* synthetic */ String bXG;
    private final /* synthetic */ String bXH;
    private final /* synthetic */ String cez;
    final /* synthetic */ PbActivity enc;
    private final /* synthetic */ long enq;
    private final /* synthetic */ String enr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ce(PbActivity pbActivity, long j, String str, String str2, String str3, String str4) {
        this.enc = pbActivity;
        this.enq = j;
        this.enr = str;
        this.bXG = str2;
        this.bXH = str3;
        this.cez = str4;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.tieba.pb.b.a(this.enq, this.enr, null, "PB", "BTN_FBCANCEL", "CLICK_FEEDBACK", "tpoint", null, null, this.bXG, this.bXH, this.cez);
        aVar.dismiss();
    }
}
