package com.baidu.tieba.tbean;

import android.text.Selection;
import android.view.View;
import android.widget.EditText;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements View.OnClickListener {
    final /* synthetic */ j crd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(j jVar) {
        this.crd = jVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EditText editText;
        EditText editText2;
        this.crd.cqY = true;
        editText = this.crd.cqT;
        editText.setSelectAllOnFocus(true);
        editText2 = this.crd.cqT;
        Selection.selectAll(editText2.getEditableText());
    }
}
