package com.baidu.tieba;

import android.view.View;
/* loaded from: classes.dex */
class u implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ t f2560a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(t tVar) {
        this.f2560a = tVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f2560a.cancel();
    }
}
