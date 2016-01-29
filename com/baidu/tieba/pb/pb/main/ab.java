package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.tbadk.core.dialog.c;
/* loaded from: classes.dex */
class ab implements c.b {
    final /* synthetic */ PbActivity cNq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(PbActivity pbActivity) {
        this.cNq = pbActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void a(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        cVar.dismiss();
        if (this.cNq.cNm != null) {
            if (i == 0) {
                this.cNq.cNm.aT(this.cNq.getPageContext().getPageActivity());
                this.cNq.cNm = null;
            } else if (i == 1 && this.cNq.checkUpIsLogin()) {
                this.cNq.d(this.cNq.cNm);
            }
        }
    }
}
