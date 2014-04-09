package com.baidu.tieba.pb.image;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
/* loaded from: classes.dex */
final class h implements TextWatcher {
    final /* synthetic */ ImagePbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(ImagePbActivity imagePbActivity) {
        this.a = imagePbActivity;
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
        Button button;
        Button button2;
        if (editable == null || editable.length() <= 0) {
            button = this.a.l;
            button.setEnabled(false);
            return;
        }
        button2 = this.a.l;
        button2.setEnabled(true);
    }
}
