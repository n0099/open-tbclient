package com.baidu.tieba.pb.pb.main;

import android.content.Intent;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bj implements a.b {
    final /* synthetic */ PbActivity emk;
    private final /* synthetic */ MarkData emv;
    private final /* synthetic */ MarkData emw;
    private final /* synthetic */ com.baidu.tbadk.core.dialog.a emx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bj(PbActivity pbActivity, MarkData markData, MarkData markData2, com.baidu.tbadk.core.dialog.a aVar) {
        this.emk = pbActivity;
        this.emv = markData;
        this.emw = markData2;
        this.emx = aVar;
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
        aVar2 = this.emk.dHE;
        if (aVar2 != null) {
            aVar3 = this.emk.dHE;
            if (aVar3.oe()) {
                aVar7 = this.emk.dHE;
                aVar7.of();
                aVar8 = this.emk.dHE;
                aVar8.ae(false);
            }
            aVar4 = this.emk.dHE;
            aVar4.a(this.emv);
            aVar5 = this.emk.dHE;
            aVar5.ae(true);
            aVar6 = this.emk.dHE;
            aVar6.og();
        }
        this.emw.setPostId(this.emv.getPostId());
        Intent intent = new Intent();
        intent.putExtra(PbActivityConfig.KEY_MARK, this.emw);
        this.emk.setResult(-1, intent);
        this.emx.dismiss();
        this.emk.aLA();
    }
}
