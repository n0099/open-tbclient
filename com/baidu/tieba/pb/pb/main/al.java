package com.baidu.tieba.pb.pb.main;

import android.content.Intent;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class al implements a.b {
    final /* synthetic */ PbActivity cCm;
    private final /* synthetic */ MarkData cCs;
    private final /* synthetic */ MarkData cCt;
    private final /* synthetic */ com.baidu.tbadk.core.dialog.a cCu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(PbActivity pbActivity, MarkData markData, MarkData markData2, com.baidu.tbadk.core.dialog.a aVar) {
        this.cCm = pbActivity;
        this.cCs = markData;
        this.cCt = markData2;
        this.cCu = aVar;
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
        aVar2 = this.cCm.cBH;
        if (aVar2 != null) {
            aVar3 = this.cCm.cBH;
            if (aVar3.qp()) {
                aVar7 = this.cCm.cBH;
                aVar7.qq();
                aVar8 = this.cCm.cBH;
                aVar8.ab(false);
            }
            aVar4 = this.cCm.cBH;
            aVar4.a(this.cCs);
            aVar5 = this.cCm.cBH;
            aVar5.ab(true);
            aVar6 = this.cCm.cBH;
            aVar6.qr();
        }
        this.cCt.setPostId(this.cCs.getPostId());
        Intent intent = new Intent();
        intent.putExtra(PbActivityConfig.KEY_MARK, this.cCt);
        this.cCm.setResult(-1, intent);
        this.cCu.dismiss();
        this.cCm.akh();
    }
}
