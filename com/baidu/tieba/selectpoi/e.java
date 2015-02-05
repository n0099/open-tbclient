package com.baidu.tieba.selectpoi;

import android.app.Activity;
import android.view.View;
import android.widget.EditText;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements View.OnClickListener {
    final /* synthetic */ SearchLocationActivity bOG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(SearchLocationActivity searchLocationActivity) {
        this.bOG = searchLocationActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EditText editText;
        EditText editText2;
        editText = this.bOG.bsv;
        if (editText.hasFocus()) {
            Activity pageActivity = this.bOG.getPageContext().getPageActivity();
            editText2 = this.bOG.bsv;
            com.baidu.adp.lib.util.l.c(pageActivity, editText2);
            this.bOG.closeActivity();
        }
    }
}
