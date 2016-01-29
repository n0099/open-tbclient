package com.baidu.tieba.postsearch;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements TextWatcher {
    final /* synthetic */ a dxD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(a aVar) {
        this.dxD = aVar;
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
        postSearchActivity = this.dxD.dxA;
        postSearchActivity.cws = editable2;
        if (editable2.trim().length() != 0) {
            textView = this.dxD.cvY;
            textView.setVisibility(0);
            return;
        }
        this.dxD.aCJ();
        textView2 = this.dxD.cvY;
        textView2.setVisibility(8);
    }
}
