package com.baidu.tieba.tbean;

import android.text.Selection;
import android.view.View;
import android.widget.EditText;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements View.OnFocusChangeListener {
    final /* synthetic */ j ccp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(j jVar) {
        this.ccp = jVar;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        EditText editText;
        EditText editText2;
        if (z) {
            this.ccp.cck = true;
            editText = this.ccp.ccf;
            editText.setSelectAllOnFocus(true);
            editText2 = this.ccp.ccf;
            Selection.selectAll(editText2.getEditableText());
        }
    }
}
