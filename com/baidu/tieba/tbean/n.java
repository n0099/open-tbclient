package com.baidu.tieba.tbean;

import android.text.Selection;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements View.OnFocusChangeListener {
    final /* synthetic */ j dKq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(j jVar) {
        this.dKq = jVar;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        TBeanEditText tBeanEditText;
        TBeanEditText tBeanEditText2;
        if (z) {
            this.dKq.dKk = true;
            tBeanEditText = this.dKq.dKf;
            tBeanEditText.setSelectAllOnFocus(true);
            tBeanEditText2 = this.dKq.dKf;
            Selection.selectAll(tBeanEditText2.getEditableText());
        }
    }
}
