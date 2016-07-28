package com.baidu.tieba.pb.pb.main;

import android.content.Intent;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bg implements a.b {
    final /* synthetic */ PbActivity ebT;
    private final /* synthetic */ MarkData ecb;
    private final /* synthetic */ com.baidu.tbadk.core.dialog.a ecc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bg(PbActivity pbActivity, MarkData markData, com.baidu.tbadk.core.dialog.a aVar) {
        this.ebT = pbActivity;
        this.ecb = markData;
        this.ecc = aVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.dismiss();
        Intent intent = new Intent();
        intent.putExtra(PbActivityConfig.KEY_MARK, this.ecb);
        this.ebT.setResult(-1, intent);
        this.ecc.dismiss();
        this.ebT.aHW();
    }
}
