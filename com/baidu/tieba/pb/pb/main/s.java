package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.tbadk.core.dialog.c;
/* loaded from: classes.dex */
class s implements c.b {
    final /* synthetic */ PbActivity ciK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(PbActivity pbActivity) {
        this.ciK = pbActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void itemClick(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        cVar.dismiss();
        if (this.ciK.ciI != null) {
            if (i == 0) {
                this.ciK.ciI.aS(this.ciK.getPageContext().getPageActivity());
                this.ciK.ciI = null;
            } else if (i == 1 && this.ciK.checkUpIsLogin()) {
                this.ciK.c(this.ciK.ciI);
            }
        }
    }
}
