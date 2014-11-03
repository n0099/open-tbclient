package com.baidu.tieba.shareSDK;

import android.text.Editable;
import android.text.TextWatcher;
/* loaded from: classes.dex */
class x implements TextWatcher {
    final /* synthetic */ p bJX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(p pVar) {
        this.bJX = pVar;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        this.bJX.acl();
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
