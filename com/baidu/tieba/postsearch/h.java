package com.baidu.tieba.postsearch;

import android.app.Activity;
import android.widget.EditText;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements Runnable {
    final /* synthetic */ a dSj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(a aVar) {
        this.dSj = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        PostSearchActivity postSearchActivity;
        EditText editText;
        postSearchActivity = this.dSj.dSg;
        Activity pageActivity = postSearchActivity.getPageContext().getPageActivity();
        editText = this.dSj.cKS;
        com.baidu.adp.lib.util.k.d(pageActivity, editText);
    }
}
