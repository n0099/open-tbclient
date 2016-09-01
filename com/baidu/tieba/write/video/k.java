package com.baidu.tieba.write.video;

import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements a.b {
    final /* synthetic */ WriteVideoActivity gcl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(WriteVideoActivity writeVideoActivity) {
        this.gcl = writeVideoActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.dismiss();
        this.gcl.beR();
        TiebaStatic.log("c10800");
        this.gcl.bsj();
        this.gcl.finish();
    }
}
