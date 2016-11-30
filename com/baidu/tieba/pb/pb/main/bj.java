package com.baidu.tieba.pb.pb.main;

import android.content.Intent;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bj implements a.b {
    final /* synthetic */ PbActivity evL;
    private final /* synthetic */ MarkData evW;
    private final /* synthetic */ com.baidu.tbadk.core.dialog.a evX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bj(PbActivity pbActivity, MarkData markData, com.baidu.tbadk.core.dialog.a aVar) {
        this.evL = pbActivity;
        this.evW = markData;
        this.evX = aVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.dismiss();
        Intent intent = new Intent();
        intent.putExtra(PbActivityConfig.KEY_MARK, this.evW);
        this.evL.setResult(-1, intent);
        this.evX.dismiss();
        this.evL.aPm();
    }
}
