package com.baidu.tieba.pb.pb.main;

import android.content.Intent;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class an implements a.b {
    final /* synthetic */ PbActivity cFS;
    private final /* synthetic */ MarkData cFZ;
    private final /* synthetic */ com.baidu.tbadk.core.dialog.a cGa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(PbActivity pbActivity, MarkData markData, com.baidu.tbadk.core.dialog.a aVar) {
        this.cFS = pbActivity;
        this.cFZ = markData;
        this.cGa = aVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.dismiss();
        Intent intent = new Intent();
        intent.putExtra(PbActivityConfig.KEY_MARK, this.cFZ);
        this.cFS.setResult(-1, intent);
        this.cGa.dismiss();
        this.cFS.alo();
    }
}
