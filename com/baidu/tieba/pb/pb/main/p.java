package com.baidu.tieba.pb.pb.main;

import android.view.View;
/* loaded from: classes.dex */
class p implements com.baidu.tbadk.core.dialog.h {
    final /* synthetic */ PbActivity bKU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(PbActivity pbActivity) {
        this.bKU = pbActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.h
    public void itemClick(com.baidu.tbadk.core.dialog.e eVar, int i, View view) {
        eVar.dismiss();
        if (this.bKU.bKS != null) {
            if (i == 0) {
                this.bKU.bKS.aJ(this.bKU.getPageContext().getPageActivity());
                this.bKU.bKS = null;
            } else if (i == 1 && this.bKU.checkUpIsLogin()) {
                this.bKU.b(this.bKU.bKS);
            }
        }
    }
}
