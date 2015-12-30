package com.baidu.tieba.postsearch;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements TextWatcher {
    final /* synthetic */ a djJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(a aVar) {
        this.djJ = aVar;
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
        postSearchActivity = this.djJ.djG;
        postSearchActivity.cpN = editable2;
        if (editable2.trim().length() != 0) {
            textView = this.djJ.cps;
            textView.setVisibility(0);
            return;
        }
        this.djJ.awo();
        textView2 = this.djJ.cps;
        textView2.setVisibility(8);
    }
}
