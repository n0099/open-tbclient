package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.tbadk.core.dialog.c;
/* loaded from: classes.dex */
class al implements c.b {
    final /* synthetic */ PbActivity dPF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(PbActivity pbActivity) {
        this.dPF = pbActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void a(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        cVar.dismiss();
        if (this.dPF.dPw != null) {
            if (i == 0) {
                this.dPF.dPw.aV(this.dPF.getPageContext().getPageActivity());
                this.dPF.dPw = null;
            } else if (i == 1 && this.dPF.checkUpIsLogin()) {
                this.dPF.c(this.dPF.dPw);
            }
        }
    }
}
