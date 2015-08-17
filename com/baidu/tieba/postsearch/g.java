package com.baidu.tieba.postsearch;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements TextWatcher {
    final /* synthetic */ a coI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(a aVar) {
        this.coI = aVar;
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
        postSearchActivity = this.coI.coG;
        postSearchActivity.bQt = editable2;
        if (editable2.trim().length() != 0) {
            textView = this.coI.bQc;
            textView.setVisibility(0);
            return;
        }
        this.coI.ahS();
        textView2 = this.coI.bQc;
        textView2.setVisibility(8);
    }
}
