package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.tbadk.core.dialog.c;
/* loaded from: classes.dex */
class al implements c.b {
    final /* synthetic */ PbActivity ejU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(PbActivity pbActivity) {
        this.ejU = pbActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void a(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        cVar.dismiss();
        if (this.ejU.ejK != null) {
            if (i == 0) {
                this.ejU.ejK.bM(this.ejU.getPageContext().getPageActivity());
                this.ejU.ejK = null;
            } else if (i == 1 && this.ejU.checkUpIsLogin()) {
                this.ejU.d(this.ejU.ejK);
            }
        }
    }
}
