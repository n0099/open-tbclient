package com.baidu.tieba.pb;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class di implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ WebActivity f1564a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public di(WebActivity webActivity) {
        this.f1564a = webActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f1564a.f();
    }
}
