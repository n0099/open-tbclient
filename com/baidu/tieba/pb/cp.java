package com.baidu.tieba.pb;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.ImageButton;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cp implements TextWatcher {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ bn f1510a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cp(bn bnVar) {
        this.f1510a = bnVar;
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        ImageButton imageButton;
        Button button;
        Button button2;
        if (editable == null || editable.length() <= 0) {
            imageButton = this.f1510a.o;
            if (imageButton.getTag() == null) {
                button = this.f1510a.j;
                button.setEnabled(false);
                return;
            }
        }
        button2 = this.f1510a.j;
        button2.setEnabled(true);
    }
}
