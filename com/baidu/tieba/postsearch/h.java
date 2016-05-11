package com.baidu.tieba.postsearch;

import android.app.Activity;
import android.widget.EditText;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements Runnable {
    final /* synthetic */ a dVb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(a aVar) {
        this.dVb = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        PostSearchActivity postSearchActivity;
        EditText editText;
        postSearchActivity = this.dVb.dUY;
        Activity pageActivity = postSearchActivity.getPageContext().getPageActivity();
        editText = this.dVb.cLO;
        com.baidu.adp.lib.util.k.b(pageActivity, editText);
    }
}
