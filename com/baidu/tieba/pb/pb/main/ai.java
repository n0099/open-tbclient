package com.baidu.tieba.pb.pb.main;

import android.content.Intent;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ai implements a.b {
    final /* synthetic */ PbActivity cjN;
    private final /* synthetic */ MarkData cjT;
    private final /* synthetic */ MarkData cjU;
    private final /* synthetic */ com.baidu.tbadk.core.dialog.a cjV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(PbActivity pbActivity, MarkData markData, MarkData markData2, com.baidu.tbadk.core.dialog.a aVar) {
        this.cjN = pbActivity;
        this.cjT = markData;
        this.cjU = markData2;
        this.cjV = aVar;
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
        aVar2 = this.cjN.cjk;
        if (aVar2 != null) {
            aVar3 = this.cjN.cjk;
            if (aVar3.qi()) {
                aVar7 = this.cjN.cjk;
                aVar7.qj();
                aVar8 = this.cjN.cjk;
                aVar8.ab(false);
            }
            aVar4 = this.cjN.cjk;
            aVar4.a(this.cjT);
            aVar5 = this.cjN.cjk;
            aVar5.ab(true);
            aVar6 = this.cjN.cjk;
            aVar6.qk();
        }
        this.cjU.setPostId(this.cjT.getPostId());
        Intent intent = new Intent();
        intent.putExtra(PbActivityConfig.KEY_MARK, this.cjU);
        this.cjN.setResult(-1, intent);
        this.cjV.dismiss();
        this.cjN.afP();
    }
}
