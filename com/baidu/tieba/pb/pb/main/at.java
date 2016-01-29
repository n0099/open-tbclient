package com.baidu.tieba.pb.pb.main;

import android.content.Intent;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class at implements a.b {
    final /* synthetic */ PbActivity cNq;
    private final /* synthetic */ MarkData cNw;
    private final /* synthetic */ MarkData cNx;
    private final /* synthetic */ com.baidu.tbadk.core.dialog.a cNy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public at(PbActivity pbActivity, MarkData markData, MarkData markData2, com.baidu.tbadk.core.dialog.a aVar) {
        this.cNq = pbActivity;
        this.cNw = markData;
        this.cNx = markData2;
        this.cNy = aVar;
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
        aVar2 = this.cNq.cMG;
        if (aVar2 != null) {
            aVar3 = this.cNq.cMG;
            if (aVar3.qg()) {
                aVar7 = this.cNq.cMG;
                aVar7.qh();
                aVar8 = this.cNq.cMG;
                aVar8.Y(false);
            }
            aVar4 = this.cNq.cMG;
            aVar4.a(this.cNw);
            aVar5 = this.cNq.cMG;
            aVar5.Y(true);
            aVar6 = this.cNq.cMG;
            aVar6.qi();
        }
        this.cNx.setPostId(this.cNw.getPostId());
        Intent intent = new Intent();
        intent.putExtra(PbActivityConfig.KEY_MARK, this.cNx);
        this.cNq.setResult(-1, intent);
        this.cNy.dismiss();
        this.cNq.aps();
    }
}
