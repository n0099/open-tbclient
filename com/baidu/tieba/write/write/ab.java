package com.baidu.tieba.write.write;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab implements View.OnFocusChangeListener {
    final /* synthetic */ WriteActivity fDQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(WriteActivity writeActivity) {
        this.fDQ = writeActivity;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        com.baidu.tbadk.editortools.j jVar;
        com.baidu.tbadk.editortools.j jVar2;
        if (z) {
            this.fDQ.fDq = false;
            this.fDQ.fDM = false;
            this.fDQ.bnh();
            jVar = this.fDQ.aun;
            if (jVar != null) {
                jVar2 = this.fDQ.aun;
                jVar2.AP();
            }
        }
    }
}
