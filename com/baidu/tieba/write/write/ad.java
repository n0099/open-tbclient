package com.baidu.tieba.write.write;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ad implements View.OnFocusChangeListener {
    final /* synthetic */ WriteActivity dsa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(WriteActivity writeActivity) {
        this.dsa = writeActivity;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        com.baidu.tbadk.editortools.j jVar;
        com.baidu.tbadk.editortools.j jVar2;
        if (z) {
            this.dsa.drT = false;
            this.dsa.drX = false;
            this.dsa.aDV();
            jVar = this.dsa.drr;
            if (jVar != null) {
                jVar2 = this.dsa.drr;
                jVar2.zc();
            }
        }
    }
}
