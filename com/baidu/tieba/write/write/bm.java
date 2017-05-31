package com.baidu.tieba.write.write;

import android.text.Editable;
import android.text.TextWatcher;
/* loaded from: classes.dex */
class bm implements TextWatcher {
    final /* synthetic */ WriteActivity gaR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bm(WriteActivity writeActivity) {
        this.gaR = writeActivity;
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        this.gaR.a(charSequence, i, i3, "from_content");
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        this.gaR.bed();
    }
}
