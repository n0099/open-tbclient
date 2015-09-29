package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.tbadk.core.dialog.c;
/* loaded from: classes.dex */
class s implements c.b {
    final /* synthetic */ PbActivity ciz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(PbActivity pbActivity) {
        this.ciz = pbActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void itemClick(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        cVar.dismiss();
        if (this.ciz.cix != null) {
            if (i == 0) {
                this.ciz.cix.aS(this.ciz.getPageContext().getPageActivity());
                this.ciz.cix = null;
            } else if (i == 1 && this.ciz.checkUpIsLogin()) {
                this.ciz.c(this.ciz.cix);
            }
        }
    }
}
