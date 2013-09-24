package com.baidu.tieba.pb;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cw implements TextWatcher {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ br f1594a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cw(br brVar) {
        this.f1594a = brVar;
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
        if (this.f1594a.b()) {
            button2 = this.f1594a.l;
            button2.setEnabled(true);
            return;
        }
        button = this.f1594a.l;
        button.setEnabled(false);
    }
}
