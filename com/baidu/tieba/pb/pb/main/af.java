package com.baidu.tieba.pb.pb.main;

import android.content.Intent;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class af implements a.b {
    final /* synthetic */ PbActivity ciK;
    private final /* synthetic */ MarkData ciQ;
    private final /* synthetic */ MarkData ciR;
    private final /* synthetic */ com.baidu.tbadk.core.dialog.a ciS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(PbActivity pbActivity, MarkData markData, MarkData markData2, com.baidu.tbadk.core.dialog.a aVar) {
        this.ciK = pbActivity;
        this.ciQ = markData;
        this.ciR = markData2;
        this.ciS = aVar;
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
        aVar2 = this.ciK.cii;
        if (aVar2 != null) {
            aVar3 = this.ciK.cii;
            if (aVar3.qk()) {
                aVar7 = this.ciK.cii;
                aVar7.ql();
                aVar8 = this.ciK.cii;
                aVar8.ab(false);
            }
            aVar4 = this.ciK.cii;
            aVar4.a(this.ciQ);
            aVar5 = this.ciK.cii;
            aVar5.ab(true);
            aVar6 = this.ciK.cii;
            aVar6.qm();
        }
        this.ciR.setPostId(this.ciQ.getPostId());
        Intent intent = new Intent();
        intent.putExtra(PbActivityConfig.KEY_MARK, this.ciR);
        this.ciK.setResult(-1, intent);
        this.ciS.dismiss();
        this.ciK.afp();
    }
}
