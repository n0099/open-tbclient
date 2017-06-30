package com.baidu.tieba.pb.pb.main;

import android.content.Intent;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bv implements a.b {
    final /* synthetic */ PbActivity ewh;
    private final /* synthetic */ MarkData ewt;
    private final /* synthetic */ com.baidu.tbadk.core.dialog.a ewu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bv(PbActivity pbActivity, MarkData markData, com.baidu.tbadk.core.dialog.a aVar) {
        this.ewh = pbActivity;
        this.ewt = markData;
        this.ewu = aVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.dismiss();
        Intent intent = new Intent();
        intent.putExtra(PbActivityConfig.KEY_MARK, this.ewt);
        this.ewh.setResult(-1, intent);
        this.ewu.dismiss();
        this.ewh.aNK();
    }
}
