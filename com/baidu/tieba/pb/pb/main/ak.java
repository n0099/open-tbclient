package com.baidu.tieba.pb.pb.main;

import android.content.Intent;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ak implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ PbActivity bIv;
    private final /* synthetic */ MarkData bIz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(PbActivity pbActivity, MarkData markData) {
        this.bIv = pbActivity;
        this.bIz = markData;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        Intent intent = new Intent();
        intent.putExtra(PbActivityConfig.KEY_MARK, this.bIz);
        this.bIv.setResult(-1, intent);
        this.bIv.Zo();
    }
}
