package com.baidu.tieba.write.selectpoi;

import android.app.Activity;
import android.view.View;
import android.widget.EditText;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements View.OnClickListener {
    final /* synthetic */ SearchLocationActivity dnw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(SearchLocationActivity searchLocationActivity) {
        this.dnw = searchLocationActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EditText editText;
        EditText editText2;
        editText = this.dnw.bVb;
        if (editText.hasFocus()) {
            Activity pageActivity = this.dnw.getPageContext().getPageActivity();
            editText2 = this.dnw.bVb;
            com.baidu.adp.lib.util.k.c(pageActivity, editText2);
            this.dnw.closeActivity();
        }
    }
}
