package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bz implements a.b {
    private final /* synthetic */ String bXe;
    private final /* synthetic */ String bYq;
    final /* synthetic */ PbActivity evL;
    private final /* synthetic */ long evY;
    private final /* synthetic */ String evZ;
    private final /* synthetic */ String ewa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bz(PbActivity pbActivity, long j, String str, String str2, String str3, String str4) {
        this.evL = pbActivity;
        this.evY = j;
        this.evZ = str;
        this.bXe = str2;
        this.bYq = str3;
        this.ewa = str4;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.tieba.pb.b.a(this.evY, this.evZ, null, "PB", "BTN_FBCANCEL", "CLICK_FEEDBACK", "tpoint", null, null, this.bXe, this.bYq, this.ewa);
        aVar.dismiss();
    }
}
