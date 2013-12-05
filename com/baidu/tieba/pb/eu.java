package com.baidu.tieba.pb;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class eu implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ WebActivity f2267a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public eu(WebActivity webActivity) {
        this.f2267a = webActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f2267a.closeActivity();
    }
}
