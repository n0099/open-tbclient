package com.baidu.tieba.pb.pb.main;

import android.content.Intent;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bj implements a.b {
    final /* synthetic */ PbActivity ejU;
    private final /* synthetic */ MarkData ekf;
    private final /* synthetic */ MarkData ekg;
    private final /* synthetic */ com.baidu.tbadk.core.dialog.a ekh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bj(PbActivity pbActivity, MarkData markData, MarkData markData2, com.baidu.tbadk.core.dialog.a aVar) {
        this.ejU = pbActivity;
        this.ekf = markData;
        this.ekg = markData2;
        this.ekh = aVar;
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
        aVar2 = this.ejU.dFo;
        if (aVar2 != null) {
            aVar3 = this.ejU.dFo;
            if (aVar3.oe()) {
                aVar7 = this.ejU.dFo;
                aVar7.of();
                aVar8 = this.ejU.dFo;
                aVar8.ae(false);
            }
            aVar4 = this.ejU.dFo;
            aVar4.a(this.ekf);
            aVar5 = this.ejU.dFo;
            aVar5.ae(true);
            aVar6 = this.ejU.dFo;
            aVar6.og();
        }
        this.ekg.setPostId(this.ekf.getPostId());
        Intent intent = new Intent();
        intent.putExtra(PbActivityConfig.KEY_MARK, this.ekg);
        this.ejU.setResult(-1, intent);
        this.ekh.dismiss();
        this.ejU.aKA();
    }
}
