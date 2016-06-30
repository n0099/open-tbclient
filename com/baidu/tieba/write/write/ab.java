package com.baidu.tieba.write.write;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab implements View.OnFocusChangeListener {
    final /* synthetic */ WriteActivity fJw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(WriteActivity writeActivity) {
        this.fJw = writeActivity;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        com.baidu.tbadk.editortools.l lVar;
        com.baidu.tbadk.editortools.l lVar2;
        if (z) {
            this.fJw.fJe = true;
            this.fJw.fJs = true;
            this.fJw.blY();
            lVar = this.fJw.aqo;
            if (lVar != null) {
                lVar2 = this.fJw.aqo;
                lVar2.zD();
            }
        }
    }
}
