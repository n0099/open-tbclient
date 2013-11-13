package com.baidu.tieba.pb;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class es implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ WebActivity f2175a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public es(WebActivity webActivity) {
        this.f2175a = webActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f2175a.closeActivity();
    }
}
