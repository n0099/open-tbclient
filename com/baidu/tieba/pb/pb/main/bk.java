package com.baidu.tieba.pb.pb.main;

import android.content.Intent;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bk implements a.b {
    final /* synthetic */ PbActivity eiV;
    private final /* synthetic */ MarkData ejg;
    private final /* synthetic */ MarkData ejh;
    private final /* synthetic */ com.baidu.tbadk.core.dialog.a eji;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bk(PbActivity pbActivity, MarkData markData, MarkData markData2, com.baidu.tbadk.core.dialog.a aVar) {
        this.eiV = pbActivity;
        this.ejg = markData;
        this.ejh = markData2;
        this.eji = aVar;
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
        aVar2 = this.eiV.dGi;
        if (aVar2 != null) {
            aVar3 = this.eiV.dGi;
            if (aVar3.nt()) {
                aVar7 = this.eiV.dGi;
                aVar7.nu();
                aVar8 = this.eiV.dGi;
                aVar8.ad(false);
            }
            aVar4 = this.eiV.dGi;
            aVar4.a(this.ejg);
            aVar5 = this.eiV.dGi;
            aVar5.ad(true);
            aVar6 = this.eiV.dGi;
            aVar6.nv();
        }
        this.ejh.setPostId(this.ejg.getPostId());
        Intent intent = new Intent();
        intent.putExtra(PbActivityConfig.KEY_MARK, this.ejh);
        this.eiV.setResult(-1, intent);
        this.eji.dismiss();
        this.eiV.aKY();
    }
}
