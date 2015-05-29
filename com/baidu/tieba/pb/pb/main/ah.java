package com.baidu.tieba.pb.pb.main;

import android.content.Intent;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ah implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ PbActivity bKT;
    private final /* synthetic */ MarkData bKX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(PbActivity pbActivity, MarkData markData) {
        this.bKT = pbActivity;
        this.bKX = markData;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        Intent intent = new Intent();
        intent.putExtra(PbActivityConfig.KEY_MARK, this.bKX);
        this.bKT.setResult(-1, intent);
        this.bKT.aaS();
    }
}
