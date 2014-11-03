package com.baidu.tieba.tbean;

import android.text.Selection;
import android.view.View;
import android.widget.EditText;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements View.OnFocusChangeListener {
    final /* synthetic */ j bOm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(j jVar) {
        this.bOm = jVar;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        EditText editText;
        EditText editText2;
        if (z) {
            this.bOm.bOh = true;
            editText = this.bOm.bOc;
            editText.setSelectAllOnFocus(true);
            editText2 = this.bOm.bOc;
            Selection.selectAll(editText2.getEditableText());
        }
    }
}
