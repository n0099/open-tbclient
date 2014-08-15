package com.baidu.tieba.person;

import android.view.View;
/* loaded from: classes.dex */
class ch implements View.OnClickListener {
    final /* synthetic */ cd a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ch(cd cdVar) {
        this.a = cdVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        cn cnVar;
        z = this.a.m;
        if (!z) {
            cd cdVar = this.a;
            cnVar = this.a.h;
            cdVar.n = cnVar.b().a().d() + 1;
            this.a.m = true;
            this.a.g();
        }
    }
}
