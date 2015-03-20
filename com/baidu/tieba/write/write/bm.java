package com.baidu.tieba.write.write;

import android.view.View;
/* loaded from: classes.dex */
class bm implements View.OnClickListener {
    final /* synthetic */ WriteActivity cyc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bm(WriteActivity writeActivity) {
        this.cyc = writeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.write.editor.b bVar;
        bVar = this.cyc.cxJ;
        switch (bVar.getLocationInfoViewState()) {
            case 0:
                this.cyc.IJ();
                return;
            case 1:
            default:
                return;
            case 2:
                this.cyc.II();
                return;
        }
    }
}
