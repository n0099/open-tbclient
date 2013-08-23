package com.baidu.tieba.write;

import android.text.Editable;
import android.text.TextWatcher;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x implements TextWatcher {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ WriteActivity f1948a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(WriteActivity writeActivity) {
        this.f1948a = writeActivity;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        this.f1948a.n();
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        this.f1948a.c = true;
    }
}
