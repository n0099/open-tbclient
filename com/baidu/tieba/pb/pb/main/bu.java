package com.baidu.tieba.pb.pb.main;

import android.content.Intent;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bu implements a.b {
    final /* synthetic */ PbActivity ewh;
    private final /* synthetic */ MarkData ews;
    private final /* synthetic */ MarkData ewt;
    private final /* synthetic */ com.baidu.tbadk.core.dialog.a ewu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bu(PbActivity pbActivity, MarkData markData, MarkData markData2, com.baidu.tbadk.core.dialog.a aVar) {
        this.ewh = pbActivity;
        this.ews = markData;
        this.ewt = markData2;
        this.ewu = aVar;
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
        aVar2 = this.ewh.dPW;
        if (aVar2 != null) {
            aVar3 = this.ewh.dPW;
            if (aVar3.nz()) {
                aVar7 = this.ewh.dPW;
                aVar7.nA();
                aVar8 = this.ewh.dPW;
                aVar8.ac(false);
            }
            aVar4 = this.ewh.dPW;
            aVar4.a(this.ews);
            aVar5 = this.ewh.dPW;
            aVar5.ac(true);
            aVar6 = this.ewh.dPW;
            aVar6.nB();
        }
        this.ewt.setPostId(this.ews.getPostId());
        Intent intent = new Intent();
        intent.putExtra(PbActivityConfig.KEY_MARK, this.ewt);
        this.ewh.setResult(-1, intent);
        this.ewu.dismiss();
        this.ewh.aNK();
    }
}
