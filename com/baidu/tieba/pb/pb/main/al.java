package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.tbadk.core.dialog.c;
/* loaded from: classes.dex */
class al implements c.b {
    final /* synthetic */ PbActivity elO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(PbActivity pbActivity) {
        this.elO = pbActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void a(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        cVar.dismiss();
        if (this.elO.elE != null) {
            if (i == 0) {
                this.elO.elE.bS(this.elO.getPageContext().getPageActivity());
                this.elO.elE = null;
            } else if (i == 1 && this.elO.checkUpIsLogin()) {
                this.elO.d(this.elO.elE);
            }
        }
    }
}
