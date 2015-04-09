package com.baidu.tieba.pb.pb.main;

import android.view.View;
/* loaded from: classes.dex */
class r implements com.baidu.tbadk.core.dialog.h {
    final /* synthetic */ PbActivity bIJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(PbActivity pbActivity) {
        this.bIJ = pbActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.h
    public void itemClick(com.baidu.tbadk.core.dialog.e eVar, int i, View view) {
        eVar.dismiss();
        if (this.bIJ.bIH != null) {
            if (i == 0) {
                this.bIJ.bIH.aE(this.bIJ.getPageContext().getPageActivity());
                this.bIJ.bIH = null;
            } else if (i == 1) {
                this.bIJ.b(this.bIJ.bIH);
            }
        }
    }
}
