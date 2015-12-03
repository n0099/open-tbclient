package com.baidu.tieba.write.write;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ad implements View.OnFocusChangeListener {
    final /* synthetic */ WriteActivity dRf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(WriteActivity writeActivity) {
        this.dRf = writeActivity;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        com.baidu.tbadk.editortools.k kVar;
        com.baidu.tbadk.editortools.k kVar2;
        if (z) {
            this.dRf.dQX = false;
            this.dRf.dRc = false;
            this.dRf.aJs();
            kVar = this.dRf.aqK;
            if (kVar != null) {
                kVar2 = this.dRf.aqK;
                kVar2.zY();
            }
        }
    }
}
