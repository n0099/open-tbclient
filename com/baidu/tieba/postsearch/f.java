package com.baidu.tieba.postsearch;

import android.view.View;
import android.widget.EditText;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements View.OnClickListener {
    final /* synthetic */ a bXO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(a aVar) {
        this.bXO = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EditText editText;
        editText = this.bXO.bBM;
        editText.setText("");
        this.bXO.afT();
    }
}
