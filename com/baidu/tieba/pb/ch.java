package com.baidu.tieba.pb;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ch implements View.OnFocusChangeListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ bn f1500a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ch(bn bnVar) {
        this.f1500a = bnVar;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        com.baidu.tieba.g gVar;
        if (!z) {
            gVar = this.f1500a.b;
            com.baidu.tieba.util.am.a(gVar, view);
        }
    }
}
