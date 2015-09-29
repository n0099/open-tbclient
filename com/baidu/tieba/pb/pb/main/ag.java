package com.baidu.tieba.pb.pb.main;

import android.content.Intent;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ag implements a.b {
    private final /* synthetic */ MarkData ciG;
    private final /* synthetic */ com.baidu.tbadk.core.dialog.a ciH;
    final /* synthetic */ PbActivity ciz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(PbActivity pbActivity, MarkData markData, com.baidu.tbadk.core.dialog.a aVar) {
        this.ciz = pbActivity;
        this.ciG = markData;
        this.ciH = aVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        Intent intent = new Intent();
        intent.putExtra(PbActivityConfig.KEY_MARK, this.ciG);
        this.ciz.setResult(-1, intent);
        this.ciH.dismiss();
        this.ciz.afp();
    }
}
