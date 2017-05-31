package com.baidu.tieba.pb.pb.main;

import android.content.Intent;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bq implements a.b {
    final /* synthetic */ PbActivity enc;
    private final /* synthetic */ MarkData eno;
    private final /* synthetic */ com.baidu.tbadk.core.dialog.a enp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bq(PbActivity pbActivity, MarkData markData, com.baidu.tbadk.core.dialog.a aVar) {
        this.enc = pbActivity;
        this.eno = markData;
        this.enp = aVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.dismiss();
        Intent intent = new Intent();
        intent.putExtra(PbActivityConfig.KEY_MARK, this.eno);
        this.enc.setResult(-1, intent);
        this.enp.dismiss();
        this.enc.aJO();
    }
}
