package com.baidu.tieba.pb.main;

import android.content.Intent;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tieba.data.MarkData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ak implements com.baidu.tbadk.core.dialog.d {
    private final /* synthetic */ MarkData bvB;
    private final /* synthetic */ MarkData bvC;
    final /* synthetic */ PbActivity bvu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(PbActivity pbActivity, MarkData markData, MarkData markData2) {
        this.bvu = pbActivity;
        this.bvB = markData;
        this.bvC = markData2;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.tieba.model.aj ajVar;
        com.baidu.tieba.model.aj ajVar2;
        com.baidu.tieba.model.aj ajVar3;
        com.baidu.tieba.model.aj ajVar4;
        com.baidu.tieba.model.aj ajVar5;
        com.baidu.tieba.model.aj ajVar6;
        ajVar = this.bvu.buV;
        if (ajVar.zP()) {
            ajVar5 = this.bvu.buV;
            ajVar5.TM();
            ajVar6 = this.bvu.buV;
            ajVar6.bs(false);
        }
        ajVar2 = this.bvu.buV;
        ajVar2.b(this.bvB);
        ajVar3 = this.bvu.buV;
        ajVar3.bs(true);
        ajVar4 = this.bvu.buV;
        ajVar4.TL();
        this.bvC.setPostId(this.bvB.getPostId());
        Intent intent = new Intent();
        intent.putExtra(PbActivityConfig.KEY_MARK, this.bvC);
        this.bvu.setResult(-1, intent);
        this.bvu.Wl();
    }
}
