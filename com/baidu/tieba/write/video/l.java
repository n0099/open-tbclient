package com.baidu.tieba.write.video;

import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements a.b {
    final /* synthetic */ WriteVideoActivity fPv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(WriteVideoActivity writeVideoActivity) {
        this.fPv = writeVideoActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.dismiss();
        this.fPv.bcB();
        TiebaStatic.log("c10800");
        this.fPv.bnd();
        this.fPv.finish();
    }
}
