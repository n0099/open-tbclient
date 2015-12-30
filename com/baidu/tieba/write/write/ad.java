package com.baidu.tieba.write.write;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ad implements View.OnFocusChangeListener {
    final /* synthetic */ WriteActivity dYD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(WriteActivity writeActivity) {
        this.dYD = writeActivity;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        com.baidu.tbadk.editortools.k kVar;
        com.baidu.tbadk.editortools.k kVar2;
        if (z) {
            this.dYD.dYv = false;
            this.dYD.dYA = false;
            this.dYD.aLN();
            kVar = this.dYD.aso;
            if (kVar != null) {
                kVar2 = this.dYD.aso;
                kVar2.zK();
            }
        }
    }
}
