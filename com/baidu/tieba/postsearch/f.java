package com.baidu.tieba.postsearch;

import android.view.View;
import android.widget.EditText;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements View.OnClickListener {
    final /* synthetic */ a bXP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(a aVar) {
        this.bXP = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EditText editText;
        editText = this.bXP.bBN;
        editText.setText("");
        this.bXP.afU();
    }
}
