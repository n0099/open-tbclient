package com.baidu.tieba.shareSDK;

import android.text.Editable;
import android.text.TextWatcher;
/* loaded from: classes.dex */
class y implements TextWatcher {
    final /* synthetic */ q bOn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(q qVar) {
        this.bOn = qVar;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        this.bOn.acG();
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
