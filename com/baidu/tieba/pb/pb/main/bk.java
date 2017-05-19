package com.baidu.tieba.pb.pb.main;

import android.content.Intent;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bk implements a.b {
    private final /* synthetic */ MarkData ehJ;
    private final /* synthetic */ MarkData ehK;
    private final /* synthetic */ com.baidu.tbadk.core.dialog.a ehL;
    final /* synthetic */ PbActivity ehy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bk(PbActivity pbActivity, MarkData markData, MarkData markData2, com.baidu.tbadk.core.dialog.a aVar) {
        this.ehy = pbActivity;
        this.ehJ = markData;
        this.ehK = markData2;
        this.ehL = aVar;
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
        aVar2 = this.ehy.dCb;
        if (aVar2 != null) {
            aVar3 = this.ehy.dCb;
            if (aVar3.nL()) {
                aVar7 = this.ehy.dCb;
                aVar7.nM();
                aVar8 = this.ehy.dCb;
                aVar8.ad(false);
            }
            aVar4 = this.ehy.dCb;
            aVar4.a(this.ehJ);
            aVar5 = this.ehy.dCb;
            aVar5.ad(true);
            aVar6 = this.ehy.dCb;
            aVar6.nN();
        }
        this.ehK.setPostId(this.ehJ.getPostId());
        Intent intent = new Intent();
        intent.putExtra(PbActivityConfig.KEY_MARK, this.ehK);
        this.ehy.setResult(-1, intent);
        this.ehL.dismiss();
        this.ehy.aIW();
    }
}
