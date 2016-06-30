package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bw implements a.b {
    private final /* synthetic */ String bIw;
    private final /* synthetic */ String bIx;
    final /* synthetic */ PbActivity dPF;
    private final /* synthetic */ long dPP;
    private final /* synthetic */ String dPQ;
    private final /* synthetic */ String dPR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bw(PbActivity pbActivity, long j, String str, String str2, String str3, String str4) {
        this.dPF = pbActivity;
        this.dPP = j;
        this.dPQ = str;
        this.bIw = str2;
        this.bIx = str3;
        this.dPR = str4;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.tieba.pb.b.a(this.dPP, this.dPQ, null, "PB", "BTN_FBCANCEL", "CLICK_FEEDBACK", "tpoint", null, null, this.bIw, this.bIx, this.dPR);
        aVar.dismiss();
    }
}
