package com.baidu.tieba.pb.pb.main;

import android.content.Intent;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aj implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ PbActivity bIv;
    private final /* synthetic */ MarkData bIy;
    private final /* synthetic */ MarkData bIz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(PbActivity pbActivity, MarkData markData, MarkData markData2) {
        this.bIv = pbActivity;
        this.bIy = markData;
        this.bIz = markData2;
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
        aVar2 = this.bIv.bHU;
        if (aVar2 != null) {
            aVar3 = this.bIv.bHU;
            if (aVar3.oQ()) {
                aVar7 = this.bIv.bHU;
                aVar7.oR();
                aVar8 = this.bIv.bHU;
                aVar8.W(false);
            }
            aVar4 = this.bIv.bHU;
            aVar4.a(this.bIy);
            aVar5 = this.bIv.bHU;
            aVar5.W(true);
            aVar6 = this.bIv.bHU;
            aVar6.oS();
        }
        this.bIz.setPostId(this.bIy.getPostId());
        Intent intent = new Intent();
        intent.putExtra(PbActivityConfig.KEY_MARK, this.bIz);
        this.bIv.setResult(-1, intent);
        this.bIv.Zo();
    }
}
