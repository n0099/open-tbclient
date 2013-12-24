package com.baidu.tieba.view;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class be implements View.OnClickListener {
    final /* synthetic */ SearchBar a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public be(SearchBar searchBar) {
        this.a = searchBar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        bf bfVar;
        bf bfVar2;
        bfVar = this.a.e;
        if (bfVar != null) {
            bfVar2 = this.a.e;
            bfVar2.b(this.a.getSearchText());
        }
    }
}
