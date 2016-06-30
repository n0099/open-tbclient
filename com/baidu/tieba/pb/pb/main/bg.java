package com.baidu.tieba.pb.pb.main;

import android.content.Intent;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bg implements a.b {
    final /* synthetic */ PbActivity dPF;
    private final /* synthetic */ MarkData dPN;
    private final /* synthetic */ com.baidu.tbadk.core.dialog.a dPO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bg(PbActivity pbActivity, MarkData markData, com.baidu.tbadk.core.dialog.a aVar) {
        this.dPF = pbActivity;
        this.dPN = markData;
        this.dPO = aVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.dismiss();
        Intent intent = new Intent();
        intent.putExtra(PbActivityConfig.KEY_MARK, this.dPN);
        this.dPF.setResult(-1, intent);
        this.dPO.dismiss();
        this.dPF.aEL();
    }
}
