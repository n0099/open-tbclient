package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.tbadk.core.dialog.c;
/* loaded from: classes.dex */
class al implements c.b {
    final /* synthetic */ PbActivity ebT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(PbActivity pbActivity) {
        this.ebT = pbActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void a(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        cVar.dismiss();
        if (this.ebT.ebK != null) {
            if (i == 0) {
                this.ebT.ebK.aV(this.ebT.getPageContext().getPageActivity());
                this.ebT.ebK = null;
            } else if (i == 1 && this.ebT.checkUpIsLogin()) {
                this.ebT.d(this.ebT.ebK);
            }
        }
    }
}
