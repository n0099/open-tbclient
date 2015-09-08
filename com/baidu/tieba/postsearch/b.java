package com.baidu.tieba.postsearch;

import android.app.Activity;
import android.view.View;
import android.widget.EditText;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements View.OnClickListener {
    final /* synthetic */ a cxf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.cxf = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EditText editText;
        PostSearchActivity postSearchActivity;
        PostSearchActivity postSearchActivity2;
        EditText editText2;
        editText = this.cxf.bQH;
        if (editText.hasFocus()) {
            postSearchActivity2 = this.cxf.cxd;
            Activity pageActivity = postSearchActivity2.getPageContext().getPageActivity();
            editText2 = this.cxf.bQH;
            com.baidu.adp.lib.util.k.c(pageActivity, editText2);
        }
        postSearchActivity = this.cxf.cxd;
        postSearchActivity.finish();
    }
}
