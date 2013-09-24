package com.baidu.tieba.pb;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class df implements TextWatcher {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ db f1603a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public df(db dbVar) {
        this.f1603a = dbVar;
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
        if (this.f1603a.u()) {
            button2 = this.f1603a.D;
            button2.setEnabled(true);
            return;
        }
        button = this.f1603a.D;
        button.setEnabled(false);
    }
}
