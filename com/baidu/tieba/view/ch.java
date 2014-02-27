package com.baidu.tieba.view;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class ch implements View.OnClickListener {
    final /* synthetic */ SearchBar a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ch(SearchBar searchBar) {
        this.a = searchBar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        ci ciVar;
        ci ciVar2;
        ciVar = this.a.e;
        if (ciVar != null) {
            ciVar2 = this.a.e;
            ciVar2.b(this.a.getSearchText());
        }
    }
}
