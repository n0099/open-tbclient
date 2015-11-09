package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.tbadk.core.dialog.c;
/* loaded from: classes.dex */
class v implements c.b {
    final /* synthetic */ PbActivity cjN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(PbActivity pbActivity) {
        this.cjN = pbActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void itemClick(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        cVar.dismiss();
        if (this.cjN.cjL != null) {
            if (i == 0) {
                this.cjN.cjL.aR(this.cjN.getPageContext().getPageActivity());
                this.cjN.cjL = null;
            } else if (i == 1 && this.cjN.checkUpIsLogin()) {
                this.cjN.c(this.cjN.cjL);
            }
        }
    }
}
