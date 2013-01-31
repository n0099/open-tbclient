package com.baidu.tieba.pb;

import android.widget.GridView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class da implements Runnable {
    final /* synthetic */ SubPbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public da(SubPbActivity subPbActivity) {
        this.a = subPbActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        GridView gridView;
        GridView gridView2;
        gridView = this.a.ad;
        if (gridView.getVisibility() != 0) {
            gridView2 = this.a.ad;
            gridView2.setVisibility(0);
        }
    }
}
