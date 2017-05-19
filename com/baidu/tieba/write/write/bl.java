package com.baidu.tieba.write.write;

import android.text.Editable;
import android.text.TextWatcher;
/* loaded from: classes.dex */
class bl implements TextWatcher {
    final /* synthetic */ WriteActivity fSV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bl(WriteActivity writeActivity) {
        this.fSV = writeActivity;
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        this.fSV.a(charSequence, i, i3, "from_title");
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        this.fSV.bcJ();
    }
}
