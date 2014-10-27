package com.baidu.tieba.write;

import android.view.View;
/* loaded from: classes.dex */
class bh implements View.OnClickListener {
    final /* synthetic */ WriteActivity bTX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bh(WriteActivity writeActivity) {
        this.bTX = writeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.editortool.j jVar;
        jVar = this.bTX.bTE;
        switch (jVar.getLocationInfoViewState()) {
            case 0:
                this.bTX.Ex();
                return;
            case 1:
            default:
                return;
            case 2:
                this.bTX.Ew();
                return;
        }
    }
}
