package com.baidu.tieba.im.updategroup;

import android.text.Editable;
import android.text.TextWatcher;
/* loaded from: classes.dex */
class h implements TextWatcher {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ g f1713a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar) {
        this.f1713a = gVar;
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        this.f1713a.h();
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        if (this.f1713a.a() == 1 && com.baidu.tieba.im.d.f.a(editable) > 20) {
            int length = editable.length() - 1;
            editable.delete(length, length + 1);
        }
    }
}
