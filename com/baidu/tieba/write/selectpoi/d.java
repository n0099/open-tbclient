package com.baidu.tieba.write.selectpoi;

import android.app.Activity;
import android.view.View;
import android.widget.EditText;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements View.OnClickListener {
    final /* synthetic */ SearchLocationActivity eZs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(SearchLocationActivity searchLocationActivity) {
        this.eZs = searchLocationActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EditText editText;
        EditText editText2;
        editText = this.eZs.cLO;
        if (editText.hasFocus()) {
            Activity pageActivity = this.eZs.getPageContext().getPageActivity();
            editText2 = this.eZs.cLO;
            com.baidu.adp.lib.util.k.a(pageActivity, editText2);
            this.eZs.closeActivity();
        }
    }
}
