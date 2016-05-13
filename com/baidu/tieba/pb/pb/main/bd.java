package com.baidu.tieba.pb.pb.main;

import android.content.Intent;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bd implements a.b {
    final /* synthetic */ PbActivity djE;
    private final /* synthetic */ MarkData djM;
    private final /* synthetic */ com.baidu.tbadk.core.dialog.a djN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bd(PbActivity pbActivity, MarkData markData, com.baidu.tbadk.core.dialog.a aVar) {
        this.djE = pbActivity;
        this.djM = markData;
        this.djN = aVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.dismiss();
        Intent intent = new Intent();
        intent.putExtra(PbActivityConfig.KEY_MARK, this.djM);
        this.djE.setResult(-1, intent);
        this.djN.dismiss();
        this.djE.awE();
    }
}
