package com.baidu.tieba.pb.pb.main;

import android.content.Intent;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aj implements a.b {
    final /* synthetic */ PbActivity cjN;
    private final /* synthetic */ MarkData cjU;
    private final /* synthetic */ com.baidu.tbadk.core.dialog.a cjV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(PbActivity pbActivity, MarkData markData, com.baidu.tbadk.core.dialog.a aVar) {
        this.cjN = pbActivity;
        this.cjU = markData;
        this.cjV = aVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.dismiss();
        Intent intent = new Intent();
        intent.putExtra(PbActivityConfig.KEY_MARK, this.cjU);
        this.cjN.setResult(-1, intent);
        this.cjV.dismiss();
        this.cjN.afP();
    }
}
