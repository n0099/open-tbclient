package com.baidu.tieba.nearby;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ NearbyPbActivity f1176a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(NearbyPbActivity nearbyPbActivity) {
        this.f1176a = nearbyPbActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f1176a.f();
    }
}
