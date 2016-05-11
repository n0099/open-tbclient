package com.baidu.tieba.write.write;

import android.view.View;
import android.widget.EditText;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ah implements View.OnClickListener {
    final /* synthetic */ WriteActivity feb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(WriteActivity writeActivity) {
        this.feb = writeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EditText editText;
        com.baidu.tbadk.editortools.l lVar;
        editText = this.feb.fai;
        editText.requestFocus();
        lVar = this.feb.apy;
        lVar.zx();
    }
}
