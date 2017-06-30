package com.baidu.tieba.write.video;

import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements a.b {
    final /* synthetic */ WriteVideoActivity gir;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(WriteVideoActivity writeVideoActivity) {
        this.gir = writeVideoActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.dismiss();
        this.gir.bik();
        TiebaStatic.log("c10800");
        this.gir.bta();
        this.gir.finish();
    }
}
