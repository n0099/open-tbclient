package com.baidu.tieba.postsearch;

import android.app.Activity;
import android.view.View;
import android.widget.EditText;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements View.OnClickListener {
    final /* synthetic */ a dVb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.dVb = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EditText editText;
        PostSearchActivity postSearchActivity;
        PostSearchActivity postSearchActivity2;
        EditText editText2;
        editText = this.dVb.cLO;
        if (editText.hasFocus()) {
            postSearchActivity2 = this.dVb.dUY;
            Activity pageActivity = postSearchActivity2.getPageContext().getPageActivity();
            editText2 = this.dVb.cLO;
            com.baidu.adp.lib.util.k.a(pageActivity, editText2);
        }
        postSearchActivity = this.dVb.dUY;
        postSearchActivity.finish();
    }
}
