package com.baidu.tieba.postsearch;

import android.app.Activity;
import android.view.View;
import android.widget.EditText;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements View.OnClickListener {
    final /* synthetic */ a bXP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.bXP = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EditText editText;
        PostSearchActivity postSearchActivity;
        PostSearchActivity postSearchActivity2;
        EditText editText2;
        editText = this.bXP.bBN;
        if (editText.hasFocus()) {
            postSearchActivity2 = this.bXP.bXN;
            Activity pageActivity = postSearchActivity2.getPageContext().getPageActivity();
            editText2 = this.bXP.bBN;
            com.baidu.adp.lib.util.n.c(pageActivity, editText2);
        }
        postSearchActivity = this.bXP.bXN;
        postSearchActivity.finish();
    }
}
