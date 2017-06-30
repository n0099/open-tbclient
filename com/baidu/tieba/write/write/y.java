package com.baidu.tieba.write.write;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y implements View.OnFocusChangeListener {
    final /* synthetic */ WriteActivity glP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(WriteActivity writeActivity) {
        this.glP = writeActivity;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        com.baidu.tbadk.editortools.j jVar;
        com.baidu.tbadk.editortools.j jVar2;
        if (z) {
            this.glP.glm = true;
            this.glP.glL = true;
            this.glP.bub();
            jVar = this.glP.azR;
            if (jVar != null) {
                jVar2 = this.glP.azR;
                jVar2.Bb();
            }
        }
    }
}
