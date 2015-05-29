package com.baidu.tieba.pb.pb.main;

import android.content.Intent;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ag implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ PbActivity bKT;
    private final /* synthetic */ MarkData bKW;
    private final /* synthetic */ MarkData bKX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(PbActivity pbActivity, MarkData markData, MarkData markData2) {
        this.bKT = pbActivity;
        this.bKW = markData;
        this.bKX = markData2;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.tbadk.baseEditMark.a aVar2;
        com.baidu.tbadk.baseEditMark.a aVar3;
        com.baidu.tbadk.baseEditMark.a aVar4;
        com.baidu.tbadk.baseEditMark.a aVar5;
        com.baidu.tbadk.baseEditMark.a aVar6;
        com.baidu.tbadk.baseEditMark.a aVar7;
        com.baidu.tbadk.baseEditMark.a aVar8;
        aVar2 = this.bKT.bKw;
        if (aVar2 != null) {
            aVar3 = this.bKT.bKw;
            if (aVar3.pq()) {
                aVar7 = this.bKT.bKw;
                aVar7.pr();
                aVar8 = this.bKT.bKw;
                aVar8.Z(false);
            }
            aVar4 = this.bKT.bKw;
            aVar4.a(this.bKW);
            aVar5 = this.bKT.bKw;
            aVar5.Z(true);
            aVar6 = this.bKT.bKw;
            aVar6.ps();
        }
        this.bKX.setPostId(this.bKW.getPostId());
        Intent intent = new Intent();
        intent.putExtra(PbActivityConfig.KEY_MARK, this.bKX);
        this.bKT.setResult(-1, intent);
        this.bKT.aaS();
    }
}
