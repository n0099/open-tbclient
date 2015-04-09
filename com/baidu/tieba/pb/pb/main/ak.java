package com.baidu.tieba.pb.pb.main;

import android.content.Intent;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ak implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ PbActivity bIJ;
    private final /* synthetic */ MarkData bIM;
    private final /* synthetic */ MarkData bIN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(PbActivity pbActivity, MarkData markData, MarkData markData2) {
        this.bIJ = pbActivity;
        this.bIM = markData;
        this.bIN = markData2;
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
        aVar2 = this.bIJ.bIh;
        if (aVar2 != null) {
            aVar3 = this.bIJ.bIh;
            if (aVar3.oQ()) {
                aVar7 = this.bIJ.bIh;
                aVar7.oR();
                aVar8 = this.bIJ.bIh;
                aVar8.W(false);
            }
            aVar4 = this.bIJ.bIh;
            aVar4.a(this.bIM);
            aVar5 = this.bIJ.bIh;
            aVar5.W(true);
            aVar6 = this.bIJ.bIh;
            aVar6.oS();
        }
        this.bIN.setPostId(this.bIM.getPostId());
        Intent intent = new Intent();
        intent.putExtra(PbActivityConfig.KEY_MARK, this.bIN);
        this.bIJ.setResult(-1, intent);
        this.bIJ.ZB();
    }
}
