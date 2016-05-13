package com.baidu.tieba.write.shareSDK;

import android.text.Editable;
import android.text.TextWatcher;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v implements TextWatcher {
    final /* synthetic */ o fav;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(o oVar) {
        this.fav = oVar;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        this.fav.bcq();
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
