package com.baidu.tieba.pb.pb.main;

import android.content.Intent;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bj implements a.b {
    final /* synthetic */ PbActivity elO;
    private final /* synthetic */ MarkData elZ;
    private final /* synthetic */ MarkData ema;
    private final /* synthetic */ com.baidu.tbadk.core.dialog.a emb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bj(PbActivity pbActivity, MarkData markData, MarkData markData2, com.baidu.tbadk.core.dialog.a aVar) {
        this.elO = pbActivity;
        this.elZ = markData;
        this.ema = markData2;
        this.emb = aVar;
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
        aVar2 = this.elO.dIP;
        if (aVar2 != null) {
            aVar3 = this.elO.dIP;
            if (aVar3.nH()) {
                aVar7 = this.elO.dIP;
                aVar7.nI();
                aVar8 = this.elO.dIP;
                aVar8.ac(false);
            }
            aVar4 = this.elO.dIP;
            aVar4.a(this.elZ);
            aVar5 = this.elO.dIP;
            aVar5.ac(true);
            aVar6 = this.elO.dIP;
            aVar6.nJ();
        }
        this.ema.setPostId(this.elZ.getPostId());
        Intent intent = new Intent();
        intent.putExtra(PbActivityConfig.KEY_MARK, this.ema);
        this.elO.setResult(-1, intent);
        this.emb.dismiss();
        this.elO.aKt();
    }
}
