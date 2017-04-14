package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bx implements a.b {
    private final /* synthetic */ String bRw;
    private final /* synthetic */ String bRx;
    private final /* synthetic */ String bYf;
    final /* synthetic */ PbActivity ejU;
    private final /* synthetic */ long eki;
    private final /* synthetic */ String ekj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bx(PbActivity pbActivity, long j, String str, String str2, String str3, String str4) {
        this.ejU = pbActivity;
        this.eki = j;
        this.ekj = str;
        this.bRw = str2;
        this.bRx = str3;
        this.bYf = str4;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.tieba.pb.b.a(this.eki, this.ekj, null, "PB", "BTN_FBCANCEL", "CLICK_FEEDBACK", "tpoint", null, null, this.bRw, this.bRx, this.bYf);
        aVar.dismiss();
    }
}
