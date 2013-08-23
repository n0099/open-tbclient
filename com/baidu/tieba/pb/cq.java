package com.baidu.tieba.pb;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.ImageButton;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cq implements TextWatcher {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ bo f1546a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cq(bo boVar) {
        this.f1546a = boVar;
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
            imageButton = this.f1546a.p;
            if (imageButton.getTag() == null) {
                button = this.f1546a.k;
                button.setEnabled(false);
                return;
            }
        }
        button2 = this.f1546a.k;
        button2.setEnabled(true);
    }
}
