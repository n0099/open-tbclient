package com.baidu.tieba.tbean;

import android.text.Selection;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements View.OnClickListener {
    final /* synthetic */ j dKq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(j jVar) {
        this.dKq = jVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TBeanEditText tBeanEditText;
        TBeanEditText tBeanEditText2;
        this.dKq.dKk = true;
        tBeanEditText = this.dKq.dKf;
        tBeanEditText.setSelectAllOnFocus(true);
        tBeanEditText2 = this.dKq.dKf;
        Selection.selectAll(tBeanEditText2.getEditableText());
    }
}
