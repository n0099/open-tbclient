package com.baidu.tieba.write.shareSDK;

import android.text.Editable;
import android.text.TextWatcher;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z implements TextWatcher {
    final /* synthetic */ q cAL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(q qVar) {
        this.cAL = qVar;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        this.cAL.asF();
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
