package com.baidu.tieba.view;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class cf implements TextWatcher {
    final /* synthetic */ SearchBar a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cf(SearchBar searchBar) {
        this.a = searchBar;
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
        ci ciVar;
        ci ciVar2;
        Button button2;
        if (this.a.getSearchText().length() > 0) {
            button2 = this.a.c;
            button2.setVisibility(0);
        } else {
            button = this.a.c;
            button.setVisibility(8);
        }
        ciVar = this.a.e;
        if (ciVar != null) {
            ciVar2 = this.a.e;
            ciVar2.a(this.a.getSearchText());
        }
    }
}
