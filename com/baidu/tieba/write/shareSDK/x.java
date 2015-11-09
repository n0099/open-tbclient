package com.baidu.tieba.write.shareSDK;

import android.text.Editable;
import android.text.TextWatcher;
/* loaded from: classes.dex */
class x implements TextWatcher {
    final /* synthetic */ o doz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(o oVar) {
        this.doz = oVar;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        this.doz.aCV();
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
