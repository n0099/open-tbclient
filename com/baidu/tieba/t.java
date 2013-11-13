package com.baidu.tieba;

import android.view.View;
/* loaded from: classes.dex */
class t implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ s f2442a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(s sVar) {
        this.f2442a = sVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f2442a.cancel();
    }
}
