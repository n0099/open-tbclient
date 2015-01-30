package com.baidu.tieba.pb.main;

import android.content.Intent;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class al implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ PbActivity bAT;
    private final /* synthetic */ MarkData bBa;
    private final /* synthetic */ MarkData bBb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(PbActivity pbActivity, MarkData markData, MarkData markData2) {
        this.bAT = pbActivity;
        this.bBa = markData;
        this.bBb = markData2;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.tbadk.baseEditMark.e eVar;
        com.baidu.tbadk.baseEditMark.e eVar2;
        com.baidu.tbadk.baseEditMark.e eVar3;
        com.baidu.tbadk.baseEditMark.e eVar4;
        com.baidu.tbadk.baseEditMark.e eVar5;
        com.baidu.tbadk.baseEditMark.e eVar6;
        eVar = this.bAT.bAt;
        if (eVar.li()) {
            eVar5 = this.bAT.bAt;
            eVar5.lm();
            eVar6 = this.bAT.bAt;
            eVar6.Y(false);
        }
        eVar2 = this.bAT.bAt;
        eVar2.b(this.bBa);
        eVar3 = this.bAT.bAt;
        eVar3.Y(true);
        eVar4 = this.bAT.bAt;
        eVar4.ll();
        this.bBb.setPostId(this.bBa.getPostId());
        Intent intent = new Intent();
        intent.putExtra(PbActivityConfig.KEY_MARK, this.bBb);
        this.bAT.setResult(-1, intent);
        this.bAT.Xn();
    }
}
