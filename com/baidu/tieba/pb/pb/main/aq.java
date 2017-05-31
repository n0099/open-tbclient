package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.tbadk.core.dialog.c;
/* loaded from: classes.dex */
class aq implements c.b {
    final /* synthetic */ PbActivity enc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aq(PbActivity pbActivity) {
        this.enc = pbActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void a(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        cVar.dismiss();
        if (this.enc.emS != null) {
            if (i == 0) {
                this.enc.emS.bT(this.enc.getPageContext().getPageActivity());
                this.enc.emS = null;
            } else if (i == 1 && this.enc.checkUpIsLogin()) {
                this.enc.g(this.enc.emS);
            }
        }
    }
}
