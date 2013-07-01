package com.baidu.tieba.pb;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.ImageButton;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cm implements TextWatcher {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ bk f1257a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cm(bk bkVar) {
        this.f1257a = bkVar;
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
            imageButton = this.f1257a.o;
            if (imageButton.getTag() == null) {
                button = this.f1257a.j;
                button.setEnabled(false);
                return;
            }
        }
        button2 = this.f1257a.j;
        button2.setEnabled(true);
    }
}
