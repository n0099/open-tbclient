package com.baidu.tieba.imMessageCenter.im.friend;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u implements TextWatcher {
    final /* synthetic */ p dbf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(p pVar) {
        this.dbf = pVar;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        TextView textView;
        TextView textView2;
        String a = com.baidu.adp.lib.util.j.a(editable, null);
        if (a != null) {
            if (a.length() > 0) {
                textView2 = this.dbf.dbd;
                textView2.setVisibility(0);
            } else {
                textView = this.dbf.dbd;
                textView.setVisibility(8);
            }
            this.dbf.aum();
        }
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
