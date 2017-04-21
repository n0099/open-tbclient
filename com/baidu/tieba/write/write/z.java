package com.baidu.tieba.write.write;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z implements View.OnFocusChangeListener {
    final /* synthetic */ WriteActivity fUM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(WriteActivity writeActivity) {
        this.fUM = writeActivity;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        com.baidu.tbadk.editortools.j jVar;
        com.baidu.tbadk.editortools.j jVar2;
        if (z) {
            this.fUM.fUm = false;
            this.fUM.fUI = false;
            this.fUM.bqc();
            jVar = this.fUM.azf;
            if (jVar != null) {
                jVar2 = this.fUM.azf;
                jVar2.BC();
            }
        }
    }
}
