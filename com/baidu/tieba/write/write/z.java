package com.baidu.tieba.write.write;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z implements View.OnFocusChangeListener {
    final /* synthetic */ WriteActivity fQG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(WriteActivity writeActivity) {
        this.fQG = writeActivity;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        com.baidu.tbadk.editortools.j jVar;
        com.baidu.tbadk.editortools.j jVar2;
        if (z) {
            this.fQG.fQg = true;
            this.fQG.fQC = true;
            this.fQG.bos();
            jVar = this.fQG.ayN;
            if (jVar != null) {
                jVar2 = this.fQG.ayN;
                jVar2.Bd();
            }
        }
    }
}
