package com.baidu.tieba.nearby;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bd implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ NewNearbyActivity f1153a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bd(NewNearbyActivity newNearbyActivity) {
        this.f1153a = newNearbyActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f1153a.u();
    }
}
