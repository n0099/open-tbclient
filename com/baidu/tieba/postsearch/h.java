package com.baidu.tieba.postsearch;

import android.app.Activity;
import android.widget.EditText;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements Runnable {
    final /* synthetic */ a djJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(a aVar) {
        this.djJ = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        PostSearchActivity postSearchActivity;
        EditText editText;
        postSearchActivity = this.djJ.djG;
        Activity pageActivity = postSearchActivity.getPageContext().getPageActivity();
        editText = this.djJ.cpr;
        com.baidu.adp.lib.util.k.d(pageActivity, editText);
    }
}
