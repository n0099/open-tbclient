package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ca implements a.b {
    private final /* synthetic */ String bKB;
    private final /* synthetic */ String bKC;
    final /* synthetic */ PbActivity eiV;
    private final /* synthetic */ long ejj;
    private final /* synthetic */ String ejk;
    private final /* synthetic */ String ejl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ca(PbActivity pbActivity, long j, String str, String str2, String str3, String str4) {
        this.eiV = pbActivity;
        this.ejj = j;
        this.ejk = str;
        this.bKB = str2;
        this.bKC = str3;
        this.ejl = str4;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.tieba.pb.b.a(this.ejj, this.ejk, null, "PB", "BTN_FBCANCEL", "CLICK_FEEDBACK", "tpoint", null, null, this.bKB, this.bKC, this.ejl);
        aVar.dismiss();
    }
}
