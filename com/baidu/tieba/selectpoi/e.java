package com.baidu.tieba.selectpoi;

import android.app.Activity;
import android.view.View;
import android.widget.EditText;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements View.OnClickListener {
    final /* synthetic */ SearchLocationActivity bMX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(SearchLocationActivity searchLocationActivity) {
        this.bMX = searchLocationActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EditText editText;
        EditText editText2;
        editText = this.bMX.bqY;
        if (editText.hasFocus()) {
            Activity pageActivity = this.bMX.getPageContext().getPageActivity();
            editText2 = this.bMX.bqY;
            com.baidu.adp.lib.util.l.c(pageActivity, editText2);
            this.bMX.closeActivity();
        }
    }
}
