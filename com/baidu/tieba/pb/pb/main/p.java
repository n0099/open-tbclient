package com.baidu.tieba.pb.pb.main;

import android.view.View;
/* loaded from: classes.dex */
class p implements com.baidu.tbadk.core.dialog.h {
    final /* synthetic */ PbActivity bKT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(PbActivity pbActivity) {
        this.bKT = pbActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.h
    public void itemClick(com.baidu.tbadk.core.dialog.e eVar, int i, View view) {
        eVar.dismiss();
        if (this.bKT.bKR != null) {
            if (i == 0) {
                this.bKT.bKR.aJ(this.bKT.getPageContext().getPageActivity());
                this.bKT.bKR = null;
            } else if (i == 1 && this.bKT.checkUpIsLogin()) {
                this.bKT.b(this.bKT.bKR);
            }
        }
    }
}
