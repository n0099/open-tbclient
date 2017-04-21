package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.tbadk.core.dialog.c;
/* loaded from: classes.dex */
class al implements c.b {
    final /* synthetic */ PbActivity emk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(PbActivity pbActivity) {
        this.emk = pbActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void a(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        cVar.dismiss();
        if (this.emk.ema != null) {
            if (i == 0) {
                this.emk.ema.bM(this.emk.getPageContext().getPageActivity());
                this.emk.ema = null;
            } else if (i == 1 && this.emk.checkUpIsLogin()) {
                this.emk.d(this.emk.ema);
            }
        }
    }
}
