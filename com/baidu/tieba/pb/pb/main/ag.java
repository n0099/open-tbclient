package com.baidu.tieba.pb.pb.main;

import android.content.Intent;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ag implements a.b {
    final /* synthetic */ PbActivity ccj;
    private final /* synthetic */ MarkData ccq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(PbActivity pbActivity, MarkData markData) {
        this.ccj = pbActivity;
        this.ccq = markData;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        Intent intent = new Intent();
        intent.putExtra(PbActivityConfig.KEY_MARK, this.ccq);
        this.ccj.setResult(-1, intent);
        this.ccj.adr();
    }
}
