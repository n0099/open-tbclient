package com.baidu.tieba.write;

import android.view.View;
/* loaded from: classes.dex */
class bh implements View.OnClickListener {
    final /* synthetic */ WriteActivity cft;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bh(WriteActivity writeActivity) {
        this.cft = writeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.tbadkCore.PbEditor.k kVar;
        kVar = this.cft.cfa;
        switch (kVar.getLocationInfoViewState()) {
            case 0:
                this.cft.ER();
                return;
            case 1:
            default:
                return;
            case 2:
                this.cft.EQ();
                return;
        }
    }
}
