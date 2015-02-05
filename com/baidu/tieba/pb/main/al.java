package com.baidu.tieba.pb.main;

import android.content.Intent;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class al implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ PbActivity bAS;
    private final /* synthetic */ MarkData bAZ;
    private final /* synthetic */ MarkData bBa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(PbActivity pbActivity, MarkData markData, MarkData markData2) {
        this.bAS = pbActivity;
        this.bAZ = markData;
        this.bBa = markData2;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.tbadk.baseEditMark.e eVar;
        com.baidu.tbadk.baseEditMark.e eVar2;
        com.baidu.tbadk.baseEditMark.e eVar3;
        com.baidu.tbadk.baseEditMark.e eVar4;
        com.baidu.tbadk.baseEditMark.e eVar5;
        com.baidu.tbadk.baseEditMark.e eVar6;
        eVar = this.bAS.bAs;
        if (eVar.lb()) {
            eVar5 = this.bAS.bAs;
            eVar5.lf();
            eVar6 = this.bAS.bAs;
            eVar6.Y(false);
        }
        eVar2 = this.bAS.bAs;
        eVar2.b(this.bAZ);
        eVar3 = this.bAS.bAs;
        eVar3.Y(true);
        eVar4 = this.bAS.bAs;
        eVar4.le();
        this.bBa.setPostId(this.bAZ.getPostId());
        Intent intent = new Intent();
        intent.putExtra(PbActivityConfig.KEY_MARK, this.bBa);
        this.bAS.setResult(-1, intent);
        this.bAS.Xi();
    }
}
