package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.tbadk.core.dialog.c;
/* loaded from: classes.dex */
class s implements c.b {
    final /* synthetic */ PbActivity ccj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(PbActivity pbActivity) {
        this.ccj = pbActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void itemClick(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        cVar.dismiss();
        if (this.ccj.cch != null) {
            if (i == 0) {
                this.ccj.cch.aT(this.ccj.getPageContext().getPageActivity());
                this.ccj.cch = null;
            } else if (i == 1 && this.ccj.checkUpIsLogin()) {
                this.ccj.b(this.ccj.cch);
            }
        }
    }
}
