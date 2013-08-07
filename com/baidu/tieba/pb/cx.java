package com.baidu.tieba.pb;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cx implements TextWatcher {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ cu f1515a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cx(cu cuVar) {
        this.f1515a = cuVar;
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        Button button;
        Button button2;
        if (editable == null || editable.length() <= 0) {
            button = this.f1515a.C;
            button.setEnabled(false);
            return;
        }
        button2 = this.f1515a.C;
        button2.setEnabled(true);
    }
}
