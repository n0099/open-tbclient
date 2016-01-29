package com.baidu.tieba.postsearch;

import android.app.Activity;
import android.view.View;
import android.widget.EditText;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements View.OnClickListener {
    final /* synthetic */ a dxD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.dxD = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EditText editText;
        PostSearchActivity postSearchActivity;
        PostSearchActivity postSearchActivity2;
        EditText editText2;
        editText = this.dxD.cvX;
        if (editText.hasFocus()) {
            postSearchActivity2 = this.dxD.dxA;
            Activity pageActivity = postSearchActivity2.getPageContext().getPageActivity();
            editText2 = this.dxD.cvX;
            com.baidu.adp.lib.util.k.c(pageActivity, editText2);
        }
        postSearchActivity = this.dxD.dxA;
        postSearchActivity.finish();
    }
}
