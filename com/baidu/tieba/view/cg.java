package com.baidu.tieba.view;

import android.view.View;
/* loaded from: classes.dex */
class cg implements View.OnClickListener {
    final /* synthetic */ SearchBar a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cg(SearchBar searchBar) {
        this.a = searchBar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.a.setSearchText("");
    }
}
