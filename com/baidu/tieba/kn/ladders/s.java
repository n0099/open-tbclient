package com.baidu.tieba.kn.ladders;

import android.view.View;
/* loaded from: classes.dex */
class s implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ KnPkHomeFragment f1228a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(KnPkHomeFragment knPkHomeFragment) {
        this.f1228a = knPkHomeFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        t tVar;
        this.f1228a.c = new t(this.f1228a, null);
        tVar = this.f1228a.c;
        tVar.execute(new Void[0]);
    }
}
