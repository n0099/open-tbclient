package com.baidu.tieba.pb.pb.main;

import android.content.Intent;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bm implements a.b {
    final /* synthetic */ PbActivity eiV;
    private final /* synthetic */ MarkData ejh;
    private final /* synthetic */ com.baidu.tbadk.core.dialog.a eji;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bm(PbActivity pbActivity, MarkData markData, com.baidu.tbadk.core.dialog.a aVar) {
        this.eiV = pbActivity;
        this.ejh = markData;
        this.eji = aVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.dismiss();
        Intent intent = new Intent();
        intent.putExtra(PbActivityConfig.KEY_MARK, this.ejh);
        this.eiV.setResult(-1, intent);
        this.eji.dismiss();
        this.eiV.aKY();
    }
}
