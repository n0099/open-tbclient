package com.baidu.tieba.write.selectpoi;

import android.app.Activity;
import android.view.View;
import android.widget.EditText;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements View.OnClickListener {
    final /* synthetic */ SearchLocationActivity czQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(SearchLocationActivity searchLocationActivity) {
        this.czQ = searchLocationActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EditText editText;
        EditText editText2;
        editText = this.czQ.bBN;
        if (editText.hasFocus()) {
            Activity pageActivity = this.czQ.getPageContext().getPageActivity();
            editText2 = this.czQ.bBN;
            com.baidu.adp.lib.util.n.c(pageActivity, editText2);
            this.czQ.closeActivity();
        }
    }
}
