package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.tbadk.core.dialog.c;
/* loaded from: classes.dex */
class al implements c.b {
    final /* synthetic */ PbActivity eiV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(PbActivity pbActivity) {
        this.eiV = pbActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void a(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        cVar.dismiss();
        if (this.eiV.eiL != null) {
            if (i == 0) {
                this.eiV.eiL.bu(this.eiV.getPageContext().getPageActivity());
                this.eiV.eiL = null;
            } else if (i == 1 && this.eiV.checkUpIsLogin()) {
                this.eiV.d(this.eiV.eiL);
            }
        }
    }
}
