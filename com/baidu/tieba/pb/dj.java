package com.baidu.tieba.pb;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class dj implements View.OnFocusChangeListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ cr f2232a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dj(cr crVar) {
        this.f2232a = crVar;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        NewPbActivity newPbActivity;
        if (!z) {
            newPbActivity = this.f2232a.g;
            com.baidu.adp.lib.h.g.a(newPbActivity, view);
        }
    }
}
