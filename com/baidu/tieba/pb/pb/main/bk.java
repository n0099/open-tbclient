package com.baidu.tieba.pb.pb.main;

import android.content.Intent;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bk implements a.b {
    final /* synthetic */ PbActivity ejU;
    private final /* synthetic */ MarkData ekg;
    private final /* synthetic */ com.baidu.tbadk.core.dialog.a ekh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bk(PbActivity pbActivity, MarkData markData, com.baidu.tbadk.core.dialog.a aVar) {
        this.ejU = pbActivity;
        this.ekg = markData;
        this.ekh = aVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.dismiss();
        Intent intent = new Intent();
        intent.putExtra(PbActivityConfig.KEY_MARK, this.ekg);
        this.ejU.setResult(-1, intent);
        this.ekh.dismiss();
        this.ejU.aKA();
    }
}
