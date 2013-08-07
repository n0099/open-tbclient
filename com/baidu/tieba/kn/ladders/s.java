package com.baidu.tieba.kn.ladders;

import android.view.View;
/* loaded from: classes.dex */
class s implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ KnPkHomeFragment f1196a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(KnPkHomeFragment knPkHomeFragment) {
        this.f1196a = knPkHomeFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        t tVar;
        this.f1196a.c = new t(this.f1196a, null);
        tVar = this.f1196a.c;
        tVar.execute(new Void[0]);
    }
}
