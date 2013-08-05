package com.baidu.tieba.kn.ladders;

import android.view.View;
/* loaded from: classes.dex */
class s implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ KnPkHomeFragment f1198a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(KnPkHomeFragment knPkHomeFragment) {
        this.f1198a = knPkHomeFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        t tVar;
        this.f1198a.c = new t(this.f1198a, null);
        tVar = this.f1198a.c;
        tVar.execute(new Void[0]);
    }
}
