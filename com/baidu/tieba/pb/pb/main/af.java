package com.baidu.tieba.pb.pb.main;

import android.content.Intent;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class af implements a.b {
    private final /* synthetic */ MarkData ciF;
    private final /* synthetic */ MarkData ciG;
    private final /* synthetic */ com.baidu.tbadk.core.dialog.a ciH;
    final /* synthetic */ PbActivity ciz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(PbActivity pbActivity, MarkData markData, MarkData markData2, com.baidu.tbadk.core.dialog.a aVar) {
        this.ciz = pbActivity;
        this.ciF = markData;
        this.ciG = markData2;
        this.ciH = aVar;
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
        aVar2 = this.ciz.chW;
        if (aVar2 != null) {
            aVar3 = this.ciz.chW;
            if (aVar3.qk()) {
                aVar7 = this.ciz.chW;
                aVar7.ql();
                aVar8 = this.ciz.chW;
                aVar8.ab(false);
            }
            aVar4 = this.ciz.chW;
            aVar4.a(this.ciF);
            aVar5 = this.ciz.chW;
            aVar5.ab(true);
            aVar6 = this.ciz.chW;
            aVar6.qm();
        }
        this.ciG.setPostId(this.ciF.getPostId());
        Intent intent = new Intent();
        intent.putExtra(PbActivityConfig.KEY_MARK, this.ciG);
        this.ciz.setResult(-1, intent);
        this.ciH.dismiss();
        this.ciz.afp();
    }
}
