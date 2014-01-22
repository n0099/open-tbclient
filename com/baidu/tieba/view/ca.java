package com.baidu.tieba.view;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ca implements View.OnClickListener {
    final /* synthetic */ SearchBar a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ca(SearchBar searchBar) {
        this.a = searchBar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        cb cbVar;
        cb cbVar2;
        cbVar = this.a.e;
        if (cbVar != null) {
            cbVar2 = this.a.e;
            cbVar2.b(this.a.getSearchText());
        }
    }
}
