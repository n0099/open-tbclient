package com.baidu.tieba.pb.pb.main;

import android.content.Intent;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class am implements a.b {
    final /* synthetic */ PbActivity cFS;
    private final /* synthetic */ MarkData cFY;
    private final /* synthetic */ MarkData cFZ;
    private final /* synthetic */ com.baidu.tbadk.core.dialog.a cGa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(PbActivity pbActivity, MarkData markData, MarkData markData2, com.baidu.tbadk.core.dialog.a aVar) {
        this.cFS = pbActivity;
        this.cFY = markData;
        this.cFZ = markData2;
        this.cGa = aVar;
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
        aVar2 = this.cFS.cFm;
        if (aVar2 != null) {
            aVar3 = this.cFS.cFm;
            if (aVar3.pN()) {
                aVar7 = this.cFS.cFm;
                aVar7.pO();
                aVar8 = this.cFS.cFm;
                aVar8.Y(false);
            }
            aVar4 = this.cFS.cFm;
            aVar4.a(this.cFY);
            aVar5 = this.cFS.cFm;
            aVar5.Y(true);
            aVar6 = this.cFS.cFm;
            aVar6.pP();
        }
        this.cFZ.setPostId(this.cFY.getPostId());
        Intent intent = new Intent();
        intent.putExtra(PbActivityConfig.KEY_MARK, this.cFZ);
        this.cFS.setResult(-1, intent);
        this.cGa.dismiss();
        this.cFS.alo();
    }
}
