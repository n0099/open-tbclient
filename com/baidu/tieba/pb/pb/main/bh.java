package com.baidu.tieba.pb.pb.main;

import android.content.Intent;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bh implements a.b {
    final /* synthetic */ PbActivity eqa;
    private final /* synthetic */ MarkData eqh;
    private final /* synthetic */ MarkData eqi;
    private final /* synthetic */ com.baidu.tbadk.core.dialog.a eqj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bh(PbActivity pbActivity, MarkData markData, MarkData markData2, com.baidu.tbadk.core.dialog.a aVar) {
        this.eqa = pbActivity;
        this.eqh = markData;
        this.eqi = markData2;
        this.eqj = aVar;
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
        aVar2 = this.eqa.dMU;
        if (aVar2 != null) {
            aVar3 = this.eqa.dMU;
            if (aVar3.nv()) {
                aVar7 = this.eqa.dMU;
                aVar7.nw();
                aVar8 = this.eqa.dMU;
                aVar8.ad(false);
            }
            aVar4 = this.eqa.dMU;
            aVar4.a(this.eqh);
            aVar5 = this.eqa.dMU;
            aVar5.ad(true);
            aVar6 = this.eqa.dMU;
            aVar6.nx();
        }
        this.eqi.setPostId(this.eqh.getPostId());
        Intent intent = new Intent();
        intent.putExtra(PbActivityConfig.KEY_MARK, this.eqi);
        this.eqa.setResult(-1, intent);
        this.eqj.dismiss();
        this.eqa.aNu();
    }
}
