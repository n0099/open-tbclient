package com.baidu.tieba.pb.pb.main;

import android.content.Intent;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class af implements a.b {
    final /* synthetic */ PbActivity cbo;
    private final /* synthetic */ MarkData cbu;
    private final /* synthetic */ MarkData cbv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(PbActivity pbActivity, MarkData markData, MarkData markData2) {
        this.cbo = pbActivity;
        this.cbu = markData;
        this.cbv = markData2;
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
        aVar2 = this.cbo.caM;
        if (aVar2 != null) {
            aVar3 = this.cbo.caM;
            if (aVar3.qr()) {
                aVar7 = this.cbo.caM;
                aVar7.qs();
                aVar8 = this.cbo.caM;
                aVar8.ab(false);
            }
            aVar4 = this.cbo.caM;
            aVar4.a(this.cbu);
            aVar5 = this.cbo.caM;
            aVar5.ab(true);
            aVar6 = this.cbo.caM;
            aVar6.qt();
        }
        this.cbv.setPostId(this.cbu.getPostId());
        Intent intent = new Intent();
        intent.putExtra(PbActivityConfig.KEY_MARK, this.cbv);
        this.cbo.setResult(-1, intent);
        this.cbo.ade();
    }
}
