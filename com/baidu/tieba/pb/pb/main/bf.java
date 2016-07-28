package com.baidu.tieba.pb.pb.main;

import android.content.Intent;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bf implements a.b {
    final /* synthetic */ PbActivity ebT;
    private final /* synthetic */ MarkData eca;
    private final /* synthetic */ MarkData ecb;
    private final /* synthetic */ com.baidu.tbadk.core.dialog.a ecc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bf(PbActivity pbActivity, MarkData markData, MarkData markData2, com.baidu.tbadk.core.dialog.a aVar) {
        this.ebT = pbActivity;
        this.eca = markData;
        this.ecb = markData2;
        this.ecc = aVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.tbadk.baseEditMark.a aVar2;
        com.baidu.tbadk.baseEditMark.a aVar3;
        com.baidu.tbadk.baseEditMark.a aVar4;
        com.baidu.tbadk.baseEditMark.a aVar5;
        com.baidu.tbadk.baseEditMark.a aVar6;
        com.baidu.tbadk.baseEditMark.a aVar7;
        com.baidu.tbadk.baseEditMark.a aVar8;
        aVar.dismiss();
        aVar2 = this.ebT.dzj;
        if (aVar2 != null) {
            aVar3 = this.ebT.dzj;
            if (aVar3.mA()) {
                aVar7 = this.ebT.dzj;
                aVar7.mB();
                aVar8 = this.ebT.dzj;
                aVar8.ab(false);
            }
            aVar4 = this.ebT.dzj;
            aVar4.a(this.eca);
            aVar5 = this.ebT.dzj;
            aVar5.ab(true);
            aVar6 = this.ebT.dzj;
            aVar6.mC();
        }
        this.ecb.setPostId(this.eca.getPostId());
        Intent intent = new Intent();
        intent.putExtra(PbActivityConfig.KEY_MARK, this.ecb);
        this.ebT.setResult(-1, intent);
        this.ecc.dismiss();
        this.ebT.aHW();
    }
}
