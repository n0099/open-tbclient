package com.baidu.tieba.im.updategroup;

import android.text.Editable;
import android.text.TextWatcher;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements TextWatcher {
    final /* synthetic */ g a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar) {
        this.a = gVar;
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        this.a.g();
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
    }
}
