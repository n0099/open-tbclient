package com.baidu.tieba.im.updategroup;

import android.text.Editable;
import android.text.TextWatcher;
/* loaded from: classes.dex */
class h implements TextWatcher {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ g f1890a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar) {
        this.f1890a = gVar;
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        this.f1890a.g();
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
    }
}
