package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.tbadk.core.dialog.c;
/* loaded from: classes.dex */
class am implements c.b {
    final /* synthetic */ PbActivity evL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(PbActivity pbActivity) {
        this.evL = pbActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void a(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        cVar.dismiss();
        if (this.evL.evC != null) {
            if (i == 0) {
                this.evL.evC.bt(this.evL.getPageContext().getPageActivity());
                this.evL.evC = null;
            } else if (i == 1 && this.evL.checkUpIsLogin()) {
                this.evL.e(this.evL.evC);
            }
        }
    }
}
