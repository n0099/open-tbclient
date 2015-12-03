package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.tbadk.core.dialog.c;
/* loaded from: classes.dex */
class w implements c.b {
    final /* synthetic */ PbActivity cCm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(PbActivity pbActivity) {
        this.cCm = pbActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void itemClick(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        cVar.dismiss();
        if (this.cCm.cCi != null) {
            if (i == 0) {
                this.cCm.cCi.aQ(this.cCm.getPageContext().getPageActivity());
                this.cCm.cCi = null;
            } else if (i == 1 && this.cCm.checkUpIsLogin()) {
                this.cCm.c(this.cCm.cCi);
            }
        }
    }
}
