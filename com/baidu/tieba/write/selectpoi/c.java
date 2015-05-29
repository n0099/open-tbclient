package com.baidu.tieba.write.selectpoi;

import android.app.Activity;
import android.view.View;
import android.widget.EditText;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements View.OnClickListener {
    final /* synthetic */ SearchLocationActivity czP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(SearchLocationActivity searchLocationActivity) {
        this.czP = searchLocationActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EditText editText;
        EditText editText2;
        editText = this.czP.bBM;
        if (editText.hasFocus()) {
            Activity pageActivity = this.czP.getPageContext().getPageActivity();
            editText2 = this.czP.bBM;
            com.baidu.adp.lib.util.n.c(pageActivity, editText2);
            this.czP.closeActivity();
        }
    }
}
