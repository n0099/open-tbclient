package com.baidu.tieba.write.write;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ad implements View.OnFocusChangeListener {
    final /* synthetic */ WriteActivity dqi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(WriteActivity writeActivity) {
        this.dqi = writeActivity;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        com.baidu.tbadk.editortools.j jVar;
        com.baidu.tbadk.editortools.j jVar2;
        if (z) {
            this.dqi.dqb = false;
            this.dqi.dqf = false;
            this.dqi.aDd();
            jVar = this.dqi.dpD;
            if (jVar != null) {
                jVar2 = this.dqi.dpD;
                jVar2.yX();
            }
        }
    }
}
