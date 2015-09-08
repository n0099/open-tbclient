package com.baidu.tieba.pb.pb.main;

import android.content.Intent;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class af implements a.b {
    final /* synthetic */ PbActivity ccj;
    private final /* synthetic */ MarkData ccp;
    private final /* synthetic */ MarkData ccq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(PbActivity pbActivity, MarkData markData, MarkData markData2) {
        this.ccj = pbActivity;
        this.ccp = markData;
        this.ccq = markData2;
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
        aVar2 = this.ccj.cbH;
        if (aVar2 != null) {
            aVar3 = this.ccj.cbH;
            if (aVar3.qo()) {
                aVar7 = this.ccj.cbH;
                aVar7.qp();
                aVar8 = this.ccj.cbH;
                aVar8.ab(false);
            }
            aVar4 = this.ccj.cbH;
            aVar4.a(this.ccp);
            aVar5 = this.ccj.cbH;
            aVar5.ab(true);
            aVar6 = this.ccj.cbH;
            aVar6.qq();
        }
        this.ccq.setPostId(this.ccp.getPostId());
        Intent intent = new Intent();
        intent.putExtra(PbActivityConfig.KEY_MARK, this.ccq);
        this.ccj.setResult(-1, intent);
        this.ccj.adr();
    }
}
