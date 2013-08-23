package com.baidu.tieba.pb;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cy implements TextWatcher {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ cv f1553a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cy(cv cvVar) {
        this.f1553a = cvVar;
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
            button = this.f1553a.C;
            button.setEnabled(false);
            return;
        }
        button2 = this.f1553a.C;
        button2.setEnabled(true);
    }
}
