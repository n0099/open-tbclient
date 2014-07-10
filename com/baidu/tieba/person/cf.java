package com.baidu.tieba.person;

import android.view.View;
/* loaded from: classes.dex */
class cf implements View.OnClickListener {
    final /* synthetic */ cb a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cf(cb cbVar) {
        this.a = cbVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        cl clVar;
        z = this.a.m;
        if (!z) {
            cb cbVar = this.a;
            clVar = this.a.h;
            cbVar.n = clVar.b().a().c() + 1;
            this.a.m = true;
            this.a.g();
        }
    }
}
