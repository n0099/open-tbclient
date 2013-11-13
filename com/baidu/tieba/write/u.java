package com.baidu.tieba.write;

import android.text.Editable;
import android.text.TextWatcher;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u implements TextWatcher {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ WriteActivity f2720a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(WriteActivity writeActivity) {
        this.f2720a = writeActivity;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        this.f2720a.t();
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        this.f2720a.d = true;
    }
}
