package com.baidu.tieba.tbean;

import android.text.Selection;
import android.view.View;
import android.widget.EditText;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements View.OnClickListener {
    final /* synthetic */ j bNX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(j jVar) {
        this.bNX = jVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EditText editText;
        EditText editText2;
        this.bNX.bNS = true;
        editText = this.bNX.bNN;
        editText.setSelectAllOnFocus(true);
        editText2 = this.bNX.bNN;
        Selection.selectAll(editText2.getEditableText());
    }
}
