package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bx implements a.b {
    private final /* synthetic */ String bVi;
    private final /* synthetic */ String bVj;
    final /* synthetic */ PbActivity eqa;
    private final /* synthetic */ long eqk;
    private final /* synthetic */ String eql;
    private final /* synthetic */ String eqm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bx(PbActivity pbActivity, long j, String str, String str2, String str3, String str4) {
        this.eqa = pbActivity;
        this.eqk = j;
        this.eql = str;
        this.bVi = str2;
        this.bVj = str3;
        this.eqm = str4;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        dh dhVar;
        dh dhVar2;
        com.baidu.tieba.pb.b.a(this.eqk, this.eql, null, "PB", "BTN_FBOK", "CLICK_FEEDBACK", "tpoint", null, null, this.bVi, this.bVj, this.eqm);
        aVar.dismiss();
        if (this.eqa.checkUpIsLogin()) {
            dhVar = this.eqa.eov;
            if (dhVar.aOS() != null) {
                dhVar2 = this.eqa.eov;
                dhVar2.aOS().cB(this.eqk);
            }
        }
    }
}
