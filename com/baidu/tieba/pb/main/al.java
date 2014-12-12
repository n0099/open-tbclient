package com.baidu.tieba.pb.main;

import android.content.Intent;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class al implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ PbActivity bzj;
    private final /* synthetic */ MarkData bzq;
    private final /* synthetic */ MarkData bzr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(PbActivity pbActivity, MarkData markData, MarkData markData2) {
        this.bzj = pbActivity;
        this.bzq = markData;
        this.bzr = markData2;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.tbadk.baseEditMark.e eVar;
        com.baidu.tbadk.baseEditMark.e eVar2;
        com.baidu.tbadk.baseEditMark.e eVar3;
        com.baidu.tbadk.baseEditMark.e eVar4;
        com.baidu.tbadk.baseEditMark.e eVar5;
        com.baidu.tbadk.baseEditMark.e eVar6;
        eVar = this.bzj.byK;
        if (eVar.li()) {
            eVar5 = this.bzj.byK;
            eVar5.lm();
            eVar6 = this.bzj.byK;
            eVar6.Y(false);
        }
        eVar2 = this.bzj.byK;
        eVar2.b(this.bzq);
        eVar3 = this.bzj.byK;
        eVar3.Y(true);
        eVar4 = this.bzj.byK;
        eVar4.ll();
        this.bzr.setPostId(this.bzq.getPostId());
        Intent intent = new Intent();
        intent.putExtra(PbActivityConfig.KEY_MARK, this.bzr);
        this.bzj.setResult(-1, intent);
        this.bzj.WI();
    }
}
