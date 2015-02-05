package com.baidu.tieba.write;

import android.view.View;
/* loaded from: classes.dex */
class bh implements View.OnClickListener {
    final /* synthetic */ WriteActivity cgR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bh(WriteActivity writeActivity) {
        this.cgR = writeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.tbadkCore.PbEditor.k kVar;
        kVar = this.cgR.cgy;
        switch (kVar.getLocationInfoViewState()) {
            case 0:
                this.cgR.Fk();
                return;
            case 1:
            default:
                return;
            case 2:
                this.cgR.Fj();
                return;
        }
    }
}
