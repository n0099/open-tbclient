package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.tbadk.core.dialog.c;
/* loaded from: classes.dex */
class ai implements c.b {
    final /* synthetic */ PbActivity djE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(PbActivity pbActivity) {
        this.djE = pbActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void a(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        cVar.dismiss();
        if (this.djE.djv != null) {
            if (i == 0) {
                this.djE.djv.aT(this.djE.getPageContext().getPageActivity());
                this.djE.djv = null;
            } else if (i == 1 && this.djE.checkUpIsLogin()) {
                this.djE.d(this.djE.djv);
            }
        }
    }
}
