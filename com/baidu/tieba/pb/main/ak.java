package com.baidu.tieba.pb.main;

import android.content.Intent;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tieba.data.MarkData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ak implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ PbActivity bvg;
    private final /* synthetic */ MarkData bvn;
    private final /* synthetic */ MarkData bvo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(PbActivity pbActivity, MarkData markData, MarkData markData2) {
        this.bvg = pbActivity;
        this.bvn = markData;
        this.bvo = markData2;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.tieba.model.aj ajVar;
        com.baidu.tieba.model.aj ajVar2;
        com.baidu.tieba.model.aj ajVar3;
        com.baidu.tieba.model.aj ajVar4;
        com.baidu.tieba.model.aj ajVar5;
        com.baidu.tieba.model.aj ajVar6;
        ajVar = this.bvg.buH;
        if (ajVar.zN()) {
            ajVar5 = this.bvg.buH;
            ajVar5.TJ();
            ajVar6 = this.bvg.buH;
            ajVar6.bs(false);
        }
        ajVar2 = this.bvg.buH;
        ajVar2.b(this.bvn);
        ajVar3 = this.bvg.buH;
        ajVar3.bs(true);
        ajVar4 = this.bvg.buH;
        ajVar4.TI();
        this.bvo.setPostId(this.bvn.getPostId());
        Intent intent = new Intent();
        intent.putExtra(PbActivityConfig.KEY_MARK, this.bvo);
        this.bvg.setResult(-1, intent);
        this.bvg.Wi();
    }
}
