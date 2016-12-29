package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.tbadk.core.dialog.c;
/* loaded from: classes.dex */
class al implements c.b {
    final /* synthetic */ PbActivity eah;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(PbActivity pbActivity) {
        this.eah = pbActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void a(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        cVar.dismiss();
        if (this.eah.dZY != null) {
            if (i == 0) {
                this.eah.dZY.bs(this.eah.getPageContext().getPageActivity());
                this.eah.dZY = null;
            } else if (i == 1 && this.eah.checkUpIsLogin()) {
                this.eah.e(this.eah.dZY);
            }
        }
    }
}
