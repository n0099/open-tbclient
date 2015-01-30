package com.baidu.tieba.tbean;

import android.text.Selection;
import android.view.View;
import android.widget.EditText;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements View.OnFocusChangeListener {
    final /* synthetic */ j ccq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(j jVar) {
        this.ccq = jVar;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        EditText editText;
        EditText editText2;
        if (z) {
            this.ccq.ccl = true;
            editText = this.ccq.ccg;
            editText.setSelectAllOnFocus(true);
            editText2 = this.ccq.ccg;
            Selection.selectAll(editText2.getEditableText());
        }
    }
}
