package com.baidu.tieba.write;

import android.view.View;
/* loaded from: classes.dex */
class bh implements View.OnClickListener {
    final /* synthetic */ WriteActivity cgS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bh(WriteActivity writeActivity) {
        this.cgS = writeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.tbadkCore.PbEditor.k kVar;
        kVar = this.cgS.cgz;
        switch (kVar.getLocationInfoViewState()) {
            case 0:
                this.cgS.Fq();
                return;
            case 1:
            default:
                return;
            case 2:
                this.cgS.Fp();
                return;
        }
    }
}
