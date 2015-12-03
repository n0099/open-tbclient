package com.baidu.tieba.write.selectpoi;

import android.app.Activity;
import android.view.View;
import android.widget.EditText;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements View.OnClickListener {
    final /* synthetic */ SearchLocationActivity dMC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(SearchLocationActivity searchLocationActivity) {
        this.dMC = searchLocationActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EditText editText;
        EditText editText2;
        editText = this.dMC.cln;
        if (editText.hasFocus()) {
            Activity pageActivity = this.dMC.getPageContext().getPageActivity();
            editText2 = this.dMC.cln;
            com.baidu.adp.lib.util.k.c(pageActivity, editText2);
            this.dMC.closeActivity();
        }
    }
}
