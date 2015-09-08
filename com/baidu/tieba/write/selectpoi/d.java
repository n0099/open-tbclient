package com.baidu.tieba.write.selectpoi;

import android.app.Activity;
import android.view.View;
import android.widget.EditText;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements View.OnClickListener {
    final /* synthetic */ SearchLocationActivity dap;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(SearchLocationActivity searchLocationActivity) {
        this.dap = searchLocationActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EditText editText;
        EditText editText2;
        editText = this.dap.bQH;
        if (editText.hasFocus()) {
            Activity pageActivity = this.dap.getPageContext().getPageActivity();
            editText2 = this.dap.bQH;
            com.baidu.adp.lib.util.k.c(pageActivity, editText2);
            this.dap.closeActivity();
        }
    }
}
