package com.baidu.tieba.view;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class by implements TextWatcher {
    final /* synthetic */ SearchBar a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public by(SearchBar searchBar) {
        this.a = searchBar;
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        Button button;
        cb cbVar;
        cb cbVar2;
        Button button2;
        if (this.a.getSearchText().length() > 0) {
            button2 = this.a.c;
            button2.setVisibility(0);
        } else {
            button = this.a.c;
            button.setVisibility(8);
        }
        cbVar = this.a.e;
        if (cbVar != null) {
            cbVar2 = this.a.e;
            cbVar2.a(this.a.getSearchText());
        }
    }
}
