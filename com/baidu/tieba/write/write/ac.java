package com.baidu.tieba.write.write;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac implements View.OnFocusChangeListener {
    final /* synthetic */ WriteActivity dYD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(WriteActivity writeActivity) {
        this.dYD = writeActivity;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        com.baidu.tbadk.editortools.k kVar;
        com.baidu.tbadk.editortools.k kVar2;
        if (z) {
            this.dYD.dYv = true;
            this.dYD.dYA = true;
            this.dYD.aLN();
            kVar = this.dYD.aso;
            if (kVar != null) {
                kVar2 = this.dYD.aso;
                kVar2.zK();
            }
        }
    }
}
