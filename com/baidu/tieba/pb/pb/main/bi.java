package com.baidu.tieba.pb.pb.main;

import android.content.Intent;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bi implements a.b {
    final /* synthetic */ PbActivity evL;
    private final /* synthetic */ MarkData evV;
    private final /* synthetic */ MarkData evW;
    private final /* synthetic */ com.baidu.tbadk.core.dialog.a evX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bi(PbActivity pbActivity, MarkData markData, MarkData markData2, com.baidu.tbadk.core.dialog.a aVar) {
        this.evL = pbActivity;
        this.evV = markData;
        this.evW = markData2;
        this.evX = aVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.tbadk.baseEditMark.a aVar2;
        com.baidu.tbadk.baseEditMark.a aVar3;
        com.baidu.tbadk.baseEditMark.a aVar4;
        com.baidu.tbadk.baseEditMark.a aVar5;
        com.baidu.tbadk.baseEditMark.a aVar6;
        com.baidu.tbadk.baseEditMark.a aVar7;
        com.baidu.tbadk.baseEditMark.a aVar8;
        aVar.dismiss();
        aVar2 = this.evL.dSz;
        if (aVar2 != null) {
            aVar3 = this.evL.dSz;
            if (aVar3.nz()) {
                aVar7 = this.evL.dSz;
                aVar7.nA();
                aVar8 = this.evL.dSz;
                aVar8.ad(false);
            }
            aVar4 = this.evL.dSz;
            aVar4.a(this.evV);
            aVar5 = this.evL.dSz;
            aVar5.ad(true);
            aVar6 = this.evL.dSz;
            aVar6.nB();
        }
        this.evW.setPostId(this.evV.getPostId());
        Intent intent = new Intent();
        intent.putExtra(PbActivityConfig.KEY_MARK, this.evW);
        this.evL.setResult(-1, intent);
        this.evX.dismiss();
        this.evL.aPm();
    }
}
