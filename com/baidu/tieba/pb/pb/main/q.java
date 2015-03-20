package com.baidu.tieba.pb.pb.main;

import android.view.View;
/* loaded from: classes.dex */
class q implements com.baidu.tbadk.core.dialog.h {
    final /* synthetic */ PbActivity bIv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(PbActivity pbActivity) {
        this.bIv = pbActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.h
    public void itemClick(com.baidu.tbadk.core.dialog.e eVar, int i, View view) {
        eVar.dismiss();
        if (this.bIv.bIt != null) {
            if (i == 0) {
                this.bIv.bIt.aE(this.bIv.getPageContext().getPageActivity());
                this.bIv.bIt = null;
            } else if (i == 1) {
                this.bIv.b(this.bIv.bIt);
            }
        }
    }
}
