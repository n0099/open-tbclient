package com.baidu.tieba.write.video;

import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements a.b {
    final /* synthetic */ WriteVideoActivity fXr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(WriteVideoActivity writeVideoActivity) {
        this.fXr = writeVideoActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.dismiss();
        this.fXr.bdV();
        TiebaStatic.log("c10800");
        this.fXr.boC();
        this.fXr.finish();
    }
}
