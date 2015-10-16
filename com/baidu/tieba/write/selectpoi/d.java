package com.baidu.tieba.write.selectpoi;

import android.app.Activity;
import android.view.View;
import android.widget.EditText;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements View.OnClickListener {
    final /* synthetic */ SearchLocationActivity dlO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(SearchLocationActivity searchLocationActivity) {
        this.dlO = searchLocationActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EditText editText;
        EditText editText2;
        editText = this.dlO.bUA;
        if (editText.hasFocus()) {
            Activity pageActivity = this.dlO.getPageContext().getPageActivity();
            editText2 = this.dlO.bUA;
            com.baidu.adp.lib.util.k.c(pageActivity, editText2);
            this.dlO.closeActivity();
        }
    }
}
