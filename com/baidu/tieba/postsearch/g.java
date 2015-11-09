package com.baidu.tieba.postsearch;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements TextWatcher {
    final /* synthetic */ a cFu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(a aVar) {
        this.cFu = aVar;
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
        postSearchActivity = this.cFu.cFs;
        postSearchActivity.bVw = editable2;
        if (editable2.trim().length() != 0) {
            textView = this.cFu.bVc;
            textView.setVisibility(0);
            return;
        }
        this.cFu.aoJ();
        textView2 = this.cFu.bVc;
        textView2.setVisibility(8);
    }
}
