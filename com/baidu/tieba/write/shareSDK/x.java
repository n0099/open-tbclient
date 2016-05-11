package com.baidu.tieba.write.shareSDK;

import android.text.Editable;
import android.text.TextWatcher;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x implements TextWatcher {
    final /* synthetic */ o faw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(o oVar) {
        this.faw = oVar;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        this.faw.bcj();
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
