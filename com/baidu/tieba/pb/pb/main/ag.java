package com.baidu.tieba.pb.pb.main;

import android.content.Intent;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ag implements a.b {
    final /* synthetic */ PbActivity cbo;
    private final /* synthetic */ MarkData cbv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(PbActivity pbActivity, MarkData markData) {
        this.cbo = pbActivity;
        this.cbv = markData;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        Intent intent = new Intent();
        intent.putExtra(PbActivityConfig.KEY_MARK, this.cbv);
        this.cbo.setResult(-1, intent);
        this.cbo.ade();
    }
}
