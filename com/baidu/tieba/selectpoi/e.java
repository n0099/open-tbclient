package com.baidu.tieba.selectpoi;

import android.app.Activity;
import android.view.View;
import android.widget.EditText;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements View.OnClickListener {
    final /* synthetic */ SearchLocationActivity bOH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(SearchLocationActivity searchLocationActivity) {
        this.bOH = searchLocationActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EditText editText;
        EditText editText2;
        editText = this.bOH.bsw;
        if (editText.hasFocus()) {
            Activity pageActivity = this.bOH.getPageContext().getPageActivity();
            editText2 = this.bOH.bsw;
            com.baidu.adp.lib.util.l.c(pageActivity, editText2);
            this.bOH.closeActivity();
        }
    }
}
