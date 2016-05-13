package com.baidu.tieba.pb.pb.main;

import android.content.Intent;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bc implements a.b {
    final /* synthetic */ PbActivity djE;
    private final /* synthetic */ MarkData djL;
    private final /* synthetic */ MarkData djM;
    private final /* synthetic */ com.baidu.tbadk.core.dialog.a djN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bc(PbActivity pbActivity, MarkData markData, MarkData markData2, com.baidu.tbadk.core.dialog.a aVar) {
        this.djE = pbActivity;
        this.djL = markData;
        this.djM = markData2;
        this.djN = aVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.tbadk.baseEditMark.a aVar2;
        com.baidu.tbadk.baseEditMark.a aVar3;
        com.baidu.tbadk.baseEditMark.a aVar4;
        com.baidu.tbadk.baseEditMark.a aVar5;
        com.baidu.tbadk.baseEditMark.a aVar6;
        com.baidu.tbadk.baseEditMark.a aVar7;
        com.baidu.tbadk.baseEditMark.a aVar8;
        aVar.dismiss();
        aVar2 = this.djE.cPW;
        if (aVar2 != null) {
            aVar3 = this.djE.cPW;
            if (aVar3.mP()) {
                aVar7 = this.djE.cPW;
                aVar7.mQ();
                aVar8 = this.djE.cPW;
                aVar8.aa(false);
            }
            aVar4 = this.djE.cPW;
            aVar4.a(this.djL);
            aVar5 = this.djE.cPW;
            aVar5.aa(true);
            aVar6 = this.djE.cPW;
            aVar6.mR();
        }
        this.djM.setPostId(this.djL.getPostId());
        Intent intent = new Intent();
        intent.putExtra(PbActivityConfig.KEY_MARK, this.djM);
        this.djE.setResult(-1, intent);
        this.djN.dismiss();
        this.djE.awE();
    }
}
