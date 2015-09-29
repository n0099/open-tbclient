package com.baidu.tieba.postsearch;

import android.view.View;
import android.widget.EditText;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements View.OnClickListener {
    final /* synthetic */ a cDN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(a aVar) {
        this.cDN = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EditText editText;
        editText = this.cDN.bUp;
        editText.setText("");
        this.cDN.aoh();
    }
}
