package com.baidu.tieba.postsearch;

import android.app.Activity;
import android.widget.EditText;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements Runnable {
    final /* synthetic */ a dxD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(a aVar) {
        this.dxD = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        PostSearchActivity postSearchActivity;
        EditText editText;
        postSearchActivity = this.dxD.dxA;
        Activity pageActivity = postSearchActivity.getPageContext().getPageActivity();
        editText = this.dxD.cvX;
        com.baidu.adp.lib.util.k.d(pageActivity, editText);
    }
}
