package com.baidu.tieba.write.write;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aa implements View.OnFocusChangeListener {
    final /* synthetic */ WriteActivity gaR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(WriteActivity writeActivity) {
        this.gaR = writeActivity;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        com.baidu.tbadk.editortools.j jVar;
        com.baidu.tbadk.editortools.j jVar2;
        if (z) {
            this.gaR.gao = true;
            this.gaR.gaM = true;
            this.gaR.bpD();
            jVar = this.gaR.ayP;
            if (jVar != null) {
                jVar2 = this.gaR.ayP;
                jVar2.AG();
            }
        }
    }
}
