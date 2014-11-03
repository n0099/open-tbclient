package com.baidu.tieba.write;

import android.view.View;
/* loaded from: classes.dex */
class bh implements View.OnClickListener {
    final /* synthetic */ WriteActivity bUm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bh(WriteActivity writeActivity) {
        this.bUm = writeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.editortool.j jVar;
        jVar = this.bUm.bTT;
        switch (jVar.getLocationInfoViewState()) {
            case 0:
                this.bUm.Ez();
                return;
            case 1:
            default:
                return;
            case 2:
                this.bUm.Ey();
                return;
        }
    }
}
