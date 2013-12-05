package com.baidu.tieba.square;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bj implements View.OnFocusChangeListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ SquareSearchActivity f2506a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bj(SquareSearchActivity squareSearchActivity) {
        this.f2506a = squareSearchActivity;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        if (!z) {
            com.baidu.adp.lib.h.g.a(this.f2506a, view);
        }
    }
}
