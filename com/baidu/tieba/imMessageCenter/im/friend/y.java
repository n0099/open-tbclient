package com.baidu.tieba.imMessageCenter.im.friend;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y implements TextWatcher {
    final /* synthetic */ t bvW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(t tVar) {
        this.bvW = tVar;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        TextView textView;
        TextView textView2;
        String a = com.baidu.adp.lib.util.m.a(editable, null);
        if (a != null) {
            if (a.length() > 0) {
                textView2 = this.bvW.bvV;
                textView2.setVisibility(0);
            } else {
                textView = this.bvW.bvV;
                textView.setVisibility(8);
            }
            this.bvW.Xc();
        }
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
