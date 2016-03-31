package com.baidu.tieba.pb.pb.main;

import android.content.Intent;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class br implements a.b {
    private final /* synthetic */ MarkData dhD;
    private final /* synthetic */ com.baidu.tbadk.core.dialog.a dhE;
    final /* synthetic */ PbActivity dht;

    /* JADX INFO: Access modifiers changed from: package-private */
    public br(PbActivity pbActivity, MarkData markData, com.baidu.tbadk.core.dialog.a aVar) {
        this.dht = pbActivity;
        this.dhD = markData;
        this.dhE = aVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.dismiss();
        Intent intent = new Intent();
        intent.putExtra(PbActivityConfig.KEY_MARK, this.dhD);
        this.dht.setResult(-1, intent);
        this.dhE.dismiss();
        this.dht.awr();
    }
}
