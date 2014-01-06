package com.baidu.tieba.view;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bi implements TextWatcher {
    final /* synthetic */ SearchBar a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bi(SearchBar searchBar) {
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
        bl blVar;
        bl blVar2;
        Button button2;
        if (this.a.getSearchText().length() > 0) {
            button2 = this.a.c;
            button2.setVisibility(0);
        } else {
            button = this.a.c;
            button.setVisibility(8);
        }
        blVar = this.a.e;
        if (blVar != null) {
            blVar2 = this.a.e;
            blVar2.a(this.a.getSearchText());
        }
    }
}
