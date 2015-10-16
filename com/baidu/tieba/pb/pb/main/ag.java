package com.baidu.tieba.pb.pb.main;

import android.content.Intent;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ag implements a.b {
    final /* synthetic */ PbActivity ciK;
    private final /* synthetic */ MarkData ciR;
    private final /* synthetic */ com.baidu.tbadk.core.dialog.a ciS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(PbActivity pbActivity, MarkData markData, com.baidu.tbadk.core.dialog.a aVar) {
        this.ciK = pbActivity;
        this.ciR = markData;
        this.ciS = aVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        Intent intent = new Intent();
        intent.putExtra(PbActivityConfig.KEY_MARK, this.ciR);
        this.ciK.setResult(-1, intent);
        this.ciS.dismiss();
        this.ciK.afp();
    }
}
