package com.baidu.tieba.write.selectpoi;

import android.app.Activity;
import android.view.View;
import android.widget.EditText;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements View.OnClickListener {
    final /* synthetic */ SearchLocationActivity fEw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(SearchLocationActivity searchLocationActivity) {
        this.fEw = searchLocationActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EditText editText;
        EditText editText2;
        editText = this.fEw.bmv;
        if (editText.hasFocus()) {
            Activity pageActivity = this.fEw.getPageContext().getPageActivity();
            editText2 = this.fEw.bmv;
            com.baidu.adp.lib.util.k.a(pageActivity, editText2);
            this.fEw.closeActivity();
        }
    }
}
