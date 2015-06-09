package com.baidu.tieba.pb.pb.main;

import android.content.Intent;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ag implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ PbActivity bKU;
    private final /* synthetic */ MarkData bKX;
    private final /* synthetic */ MarkData bKY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(PbActivity pbActivity, MarkData markData, MarkData markData2) {
        this.bKU = pbActivity;
        this.bKX = markData;
        this.bKY = markData2;
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
        aVar2 = this.bKU.bKx;
        if (aVar2 != null) {
            aVar3 = this.bKU.bKx;
            if (aVar3.pq()) {
                aVar7 = this.bKU.bKx;
                aVar7.pr();
                aVar8 = this.bKU.bKx;
                aVar8.Z(false);
            }
            aVar4 = this.bKU.bKx;
            aVar4.a(this.bKX);
            aVar5 = this.bKU.bKx;
            aVar5.Z(true);
            aVar6 = this.bKU.bKx;
            aVar6.ps();
        }
        this.bKY.setPostId(this.bKX.getPostId());
        Intent intent = new Intent();
        intent.putExtra(PbActivityConfig.KEY_MARK, this.bKY);
        this.bKU.setResult(-1, intent);
        this.bKU.aaT();
    }
}
