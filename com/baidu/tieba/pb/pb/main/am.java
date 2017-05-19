package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.tbadk.core.dialog.c;
/* loaded from: classes.dex */
class am implements c.b {
    final /* synthetic */ PbActivity ehy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(PbActivity pbActivity) {
        this.ehy = pbActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void a(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        cVar.dismiss();
        if (this.ehy.eho != null) {
            if (i == 0) {
                this.ehy.eho.bS(this.ehy.getPageContext().getPageActivity());
                this.ehy.eho = null;
            } else if (i == 1 && this.ehy.checkUpIsLogin()) {
                this.ehy.f(this.ehy.eho);
            }
        }
    }
}
