package com.baidu.tieba.pb.pb.main;

import android.content.Intent;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bq implements a.b {
    private final /* synthetic */ MarkData dhC;
    private final /* synthetic */ MarkData dhD;
    private final /* synthetic */ com.baidu.tbadk.core.dialog.a dhE;
    final /* synthetic */ PbActivity dht;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bq(PbActivity pbActivity, MarkData markData, MarkData markData2, com.baidu.tbadk.core.dialog.a aVar) {
        this.dht = pbActivity;
        this.dhC = markData;
        this.dhD = markData2;
        this.dhE = aVar;
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
        aVar2 = this.dht.cOZ;
        if (aVar2 != null) {
            aVar3 = this.dht.cOZ;
            if (aVar3.pu()) {
                aVar7 = this.dht.cOZ;
                aVar7.pv();
                aVar8 = this.dht.cOZ;
                aVar8.X(false);
            }
            aVar4 = this.dht.cOZ;
            aVar4.a(this.dhC);
            aVar5 = this.dht.cOZ;
            aVar5.X(true);
            aVar6 = this.dht.cOZ;
            aVar6.pw();
        }
        this.dhD.setPostId(this.dhC.getPostId());
        Intent intent = new Intent();
        intent.putExtra(PbActivityConfig.KEY_MARK, this.dhD);
        this.dht.setResult(-1, intent);
        this.dhE.dismiss();
        this.dht.awr();
    }
}
