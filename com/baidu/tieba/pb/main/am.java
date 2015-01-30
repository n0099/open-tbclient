package com.baidu.tieba.pb.main;

import android.content.Intent;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class am implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ PbActivity bAT;
    private final /* synthetic */ MarkData bBb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(PbActivity pbActivity, MarkData markData) {
        this.bAT = pbActivity;
        this.bBb = markData;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        Intent intent = new Intent();
        intent.putExtra(PbActivityConfig.KEY_MARK, this.bBb);
        this.bAT.setResult(-1, intent);
        this.bAT.Xn();
    }
}
