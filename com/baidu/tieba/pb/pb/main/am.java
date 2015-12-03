package com.baidu.tieba.pb.pb.main;

import android.content.Intent;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class am implements a.b {
    final /* synthetic */ PbActivity cCm;
    private final /* synthetic */ MarkData cCt;
    private final /* synthetic */ com.baidu.tbadk.core.dialog.a cCu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(PbActivity pbActivity, MarkData markData, com.baidu.tbadk.core.dialog.a aVar) {
        this.cCm = pbActivity;
        this.cCt = markData;
        this.cCu = aVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.dismiss();
        Intent intent = new Intent();
        intent.putExtra(PbActivityConfig.KEY_MARK, this.cCt);
        this.cCm.setResult(-1, intent);
        this.cCu.dismiss();
        this.cCm.akh();
    }
}
