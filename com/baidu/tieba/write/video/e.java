package com.baidu.tieba.write.video;

import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements a.b {
    final /* synthetic */ WriteLocationView gij;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(WriteLocationView writeLocationView) {
        this.gij = writeLocationView;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        this.gij.c(0, true, null);
        aVar.dismiss();
    }
}
