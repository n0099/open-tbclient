package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.tbadk.core.dialog.c;
/* loaded from: classes.dex */
class am implements c.b {
    final /* synthetic */ PbActivity eqa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(PbActivity pbActivity) {
        this.eqa = pbActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void a(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        cVar.dismiss();
        if (this.eqa.epR != null) {
            if (i == 0) {
                this.eqa.epR.bf(this.eqa.getPageContext().getPageActivity());
                this.eqa.epR = null;
            } else if (i == 1 && this.eqa.checkUpIsLogin()) {
                this.eqa.d(this.eqa.epR);
            }
        }
    }
}
