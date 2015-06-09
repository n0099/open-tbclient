package com.baidu.tieba.tbean;

import android.text.Selection;
import android.view.View;
import android.widget.EditText;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements View.OnClickListener {
    final /* synthetic */ j cvi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(j jVar) {
        this.cvi = jVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EditText editText;
        EditText editText2;
        this.cvi.cvd = true;
        editText = this.cvi.cuY;
        editText.setSelectAllOnFocus(true);
        editText2 = this.cvi.cuY;
        Selection.selectAll(editText2.getEditableText());
    }
}
