package com.baidu.tieba.write.shareSDK;

import android.text.Editable;
import android.text.TextWatcher;
/* loaded from: classes.dex */
class v implements TextWatcher {
    final /* synthetic */ o dVe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(o oVar) {
        this.dVe = oVar;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        this.dVe.aKN();
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
