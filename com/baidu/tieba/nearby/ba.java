package com.baidu.tieba.nearby;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ba implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ NewNearbyActivity f1150a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ba(NewNearbyActivity newNearbyActivity) {
        this.f1150a = newNearbyActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f1150a.v();
    }
}
