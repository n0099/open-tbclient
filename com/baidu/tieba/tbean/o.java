package com.baidu.tieba.tbean;

import android.text.Selection;
import android.view.View;
import android.widget.EditText;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements View.OnClickListener {
    final /* synthetic */ j ccq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(j jVar) {
        this.ccq = jVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EditText editText;
        EditText editText2;
        this.ccq.ccl = true;
        editText = this.ccq.ccg;
        editText.setSelectAllOnFocus(true);
        editText2 = this.ccq.ccg;
        Selection.selectAll(editText2.getEditableText());
    }
}
