package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bw implements a.b {
    private final /* synthetic */ String bKa;
    private final /* synthetic */ String bKb;
    final /* synthetic */ PbActivity ebT;
    private final /* synthetic */ long ecd;
    private final /* synthetic */ String ece;
    private final /* synthetic */ String ecf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bw(PbActivity pbActivity, long j, String str, String str2, String str3, String str4) {
        this.ebT = pbActivity;
        this.ecd = j;
        this.ece = str;
        this.bKa = str2;
        this.bKb = str3;
        this.ecf = str4;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.tieba.pb.b.a(this.ecd, this.ece, null, "PB", "BTN_FBCANCEL", "CLICK_FEEDBACK", "tpoint", null, null, this.bKa, this.bKb, this.ecf);
        aVar.dismiss();
    }
}
