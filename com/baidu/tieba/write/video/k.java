package com.baidu.tieba.write.video;

import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements a.b {
    final /* synthetic */ WriteVideoActivity eJN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(WriteVideoActivity writeVideoActivity) {
        this.eJN = writeVideoActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.dismiss();
        this.eJN.aZP();
        TiebaStatic.log("c10800");
        this.eJN.bah();
        this.eJN.finish();
    }
}
