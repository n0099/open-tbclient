package com.baidu.tieba.tbean;

import android.text.Selection;
import android.view.View;
import android.widget.EditText;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements View.OnClickListener {
    final /* synthetic */ j cqN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(j jVar) {
        this.cqN = jVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EditText editText;
        EditText editText2;
        this.cqN.cqI = true;
        editText = this.cqN.cqD;
        editText.setSelectAllOnFocus(true);
        editText2 = this.cqN.cqD;
        Selection.selectAll(editText2.getEditableText());
    }
}
