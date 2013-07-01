package com.baidu.tieba.nearby;

import android.widget.GridView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ NearbyPbActivity f1183a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(NearbyPbActivity nearbyPbActivity) {
        this.f1183a = nearbyPbActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        GridView gridView;
        GridView gridView2;
        gridView = this.f1183a.g;
        if (gridView.getVisibility() != 0) {
            gridView2 = this.f1183a.g;
            gridView2.setVisibility(0);
        }
    }
}
