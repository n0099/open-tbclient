package com.baidu.tieba.pb.pb.main;

import android.content.Intent;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bi implements a.b {
    final /* synthetic */ PbActivity eah;
    private final /* synthetic */ MarkData ear;
    private final /* synthetic */ MarkData eas;
    private final /* synthetic */ com.baidu.tbadk.core.dialog.a eat;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bi(PbActivity pbActivity, MarkData markData, MarkData markData2, com.baidu.tbadk.core.dialog.a aVar) {
        this.eah = pbActivity;
        this.ear = markData;
        this.eas = markData2;
        this.eat = aVar;
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
        aVar2 = this.eah.dxb;
        if (aVar2 != null) {
            aVar3 = this.eah.dxb;
            if (aVar3.nz()) {
                aVar7 = this.eah.dxb;
                aVar7.nA();
                aVar8 = this.eah.dxb;
                aVar8.ad(false);
            }
            aVar4 = this.eah.dxb;
            aVar4.a(this.ear);
            aVar5 = this.eah.dxb;
            aVar5.ad(true);
            aVar6 = this.eah.dxb;
            aVar6.nB();
        }
        this.eas.setPostId(this.ear.getPostId());
        Intent intent = new Intent();
        intent.putExtra(PbActivityConfig.KEY_MARK, this.eas);
        this.eah.setResult(-1, intent);
        this.eat.dismiss();
        this.eah.aJl();
    }
}
