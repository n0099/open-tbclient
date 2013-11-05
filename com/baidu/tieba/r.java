package com.baidu.tieba;

import android.view.View;
/* loaded from: classes.dex */
class r implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ q f2262a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(q qVar) {
        this.f2262a = qVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f2262a.cancel();
    }
}
