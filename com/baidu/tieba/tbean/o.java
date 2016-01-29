package com.baidu.tieba.tbean;

import android.text.Selection;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements View.OnClickListener {
    final /* synthetic */ j eav;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(j jVar) {
        this.eav = jVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TBeanEditText tBeanEditText;
        TBeanEditText tBeanEditText2;
        this.eav.eap = true;
        tBeanEditText = this.eav.eak;
        tBeanEditText.setSelectAllOnFocus(true);
        tBeanEditText2 = this.eav.eak;
        Selection.selectAll(tBeanEditText2.getEditableText());
    }
}
