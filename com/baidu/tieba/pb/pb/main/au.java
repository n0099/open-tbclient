package com.baidu.tieba.pb.pb.main;

import android.content.Intent;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class au implements a.b {
    final /* synthetic */ PbActivity cNq;
    private final /* synthetic */ MarkData cNx;
    private final /* synthetic */ com.baidu.tbadk.core.dialog.a cNy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public au(PbActivity pbActivity, MarkData markData, com.baidu.tbadk.core.dialog.a aVar) {
        this.cNq = pbActivity;
        this.cNx = markData;
        this.cNy = aVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.dismiss();
        Intent intent = new Intent();
        intent.putExtra(PbActivityConfig.KEY_MARK, this.cNx);
        this.cNq.setResult(-1, intent);
        this.cNy.dismiss();
        this.cNq.aps();
    }
}
