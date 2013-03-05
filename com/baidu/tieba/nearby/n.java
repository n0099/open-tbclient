package com.baidu.tieba.nearby;

import android.widget.GridView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements Runnable {
    final /* synthetic */ NearbyPbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(NearbyPbActivity nearbyPbActivity) {
        this.a = nearbyPbActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        GridView gridView;
        GridView gridView2;
        gridView = this.a.j;
        if (gridView.getVisibility() != 0) {
            gridView2 = this.a.j;
            gridView2.setVisibility(0);
        }
    }
}
