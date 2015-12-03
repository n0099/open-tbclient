package com.baidu.tieba.tbean;

import android.text.Selection;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements View.OnFocusChangeListener {
    final /* synthetic */ j dCO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(j jVar) {
        this.dCO = jVar;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        TBeanEditText tBeanEditText;
        TBeanEditText tBeanEditText2;
        if (z) {
            this.dCO.dCI = true;
            tBeanEditText = this.dCO.dCD;
            tBeanEditText.setSelectAllOnFocus(true);
            tBeanEditText2 = this.dCO.dCD;
            Selection.selectAll(tBeanEditText2.getEditableText());
        }
    }
}
