package com.baidu.tieba.postsearch;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements TextWatcher {
    final /* synthetic */ a dSj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(a aVar) {
        this.dSj = aVar;
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        PostSearchActivity postSearchActivity;
        TextView textView;
        TextView textView2;
        String editable2 = editable.toString();
        postSearchActivity = this.dSj.dSg;
        postSearchActivity.cLn = editable2;
        if (editable2.trim().length() != 0) {
            textView = this.dSj.cKT;
            textView.setVisibility(0);
            return;
        }
        this.dSj.aKx();
        textView2 = this.dSj.cKT;
        textView2.setVisibility(8);
    }
}
