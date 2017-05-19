package com.baidu.tieba.pb.pb.main;

import android.content.Intent;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bm implements a.b {
    private final /* synthetic */ MarkData ehK;
    private final /* synthetic */ com.baidu.tbadk.core.dialog.a ehL;
    final /* synthetic */ PbActivity ehy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bm(PbActivity pbActivity, MarkData markData, com.baidu.tbadk.core.dialog.a aVar) {
        this.ehy = pbActivity;
        this.ehK = markData;
        this.ehL = aVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.dismiss();
        Intent intent = new Intent();
        intent.putExtra(PbActivityConfig.KEY_MARK, this.ehK);
        this.ehy.setResult(-1, intent);
        this.ehL.dismiss();
        this.ehy.aIW();
    }
}
