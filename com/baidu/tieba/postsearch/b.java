package com.baidu.tieba.postsearch;

import android.app.Activity;
import android.view.View;
import android.widget.EditText;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements View.OnClickListener {
    final /* synthetic */ a ded;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.ded = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EditText editText;
        PostSearchActivity postSearchActivity;
        PostSearchActivity postSearchActivity2;
        EditText editText2;
        editText = this.ded.cln;
        if (editText.hasFocus()) {
            postSearchActivity2 = this.ded.deb;
            Activity pageActivity = postSearchActivity2.getPageContext().getPageActivity();
            editText2 = this.ded.cln;
            com.baidu.adp.lib.util.k.c(pageActivity, editText2);
        }
        postSearchActivity = this.ded.deb;
        postSearchActivity.finish();
    }
}
