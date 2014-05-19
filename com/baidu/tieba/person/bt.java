package com.baidu.tieba.person;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bt implements View.OnClickListener {
    final /* synthetic */ bm a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bt(bm bmVar) {
        this.a = bmVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        aj ajVar;
        ajVar = this.a.k;
        ajVar.h();
        this.a.n();
    }
}
