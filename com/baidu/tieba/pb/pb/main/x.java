package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.tbadk.core.dialog.c;
/* loaded from: classes.dex */
class x implements c.b {
    final /* synthetic */ PbActivity cFS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(PbActivity pbActivity) {
        this.cFS = pbActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void itemClick(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        cVar.dismiss();
        if (this.cFS.cFO != null) {
            if (i == 0) {
                this.cFS.cFO.aR(this.cFS.getPageContext().getPageActivity());
                this.cFS.cFO = null;
            } else if (i == 1 && this.cFS.checkUpIsLogin()) {
                this.cFS.c(this.cFS.cFO);
            }
        }
    }
}
