package com.baidu.tieba.write.write;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab implements View.OnFocusChangeListener {
    final /* synthetic */ WriteActivity gpp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(WriteActivity writeActivity) {
        this.gpp = writeActivity;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        com.baidu.tbadk.editortools.l lVar;
        com.baidu.tbadk.editortools.l lVar2;
        if (z) {
            this.gpp.goO = false;
            this.gpp.gpl = false;
            this.gpp.bwj();
            lVar = this.gpp.auI;
            if (lVar != null) {
                lVar2 = this.gpp.auI;
                lVar2.Bc();
            }
        }
    }
}
