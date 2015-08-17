package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.tbadk.core.dialog.c;
/* loaded from: classes.dex */
class s implements c.b {
    final /* synthetic */ PbActivity cbo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(PbActivity pbActivity) {
        this.cbo = pbActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void itemClick(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        cVar.dismiss();
        if (this.cbo.cbm != null) {
            if (i == 0) {
                this.cbo.cbm.aQ(this.cbo.getPageContext().getPageActivity());
                this.cbo.cbm = null;
            } else if (i == 1 && this.cbo.checkUpIsLogin()) {
                this.cbo.b(this.cbo.cbm);
            }
        }
    }
}
