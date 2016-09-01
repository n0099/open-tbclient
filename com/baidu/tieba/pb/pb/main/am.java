package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.tbadk.core.dialog.c;
/* loaded from: classes.dex */
class am implements c.b {
    final /* synthetic */ PbActivity eob;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(PbActivity pbActivity) {
        this.eob = pbActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void a(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        cVar.dismiss();
        if (this.eob.enS != null) {
            if (i == 0) {
                this.eob.enS.bi(this.eob.getPageContext().getPageActivity());
                this.eob.enS = null;
            } else if (i == 1 && this.eob.checkUpIsLogin()) {
                this.eob.d(this.eob.enS);
            }
        }
    }
}
