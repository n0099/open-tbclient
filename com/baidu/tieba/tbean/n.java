package com.baidu.tieba.tbean;

import android.text.Selection;
import android.view.View;
import android.widget.EditText;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements View.OnFocusChangeListener {
    final /* synthetic */ j cqN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(j jVar) {
        this.cqN = jVar;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        EditText editText;
        EditText editText2;
        if (z) {
            this.cqN.cqI = true;
            editText = this.cqN.cqD;
            editText.setSelectAllOnFocus(true);
            editText2 = this.cqN.cqD;
            Selection.selectAll(editText2.getEditableText());
        }
    }
}
