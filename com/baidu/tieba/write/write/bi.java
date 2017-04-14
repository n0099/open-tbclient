package com.baidu.tieba.write.write;

import android.text.Editable;
import android.text.TextWatcher;
/* loaded from: classes.dex */
class bi implements TextWatcher {
    final /* synthetic */ WriteActivity fSq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bi(WriteActivity writeActivity) {
        this.fSq = writeActivity;
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        this.fSq.a(charSequence, i, i3, "from_content");
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        this.fSq.bee();
    }
}
