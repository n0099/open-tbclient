package com.baidu.tieba.pb;

import android.widget.GridView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class dg implements Runnable {
    final /* synthetic */ SubPbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dg(SubPbActivity subPbActivity) {
        this.a = subPbActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        GridView gridView;
        GridView gridView2;
        gridView = this.a.Y;
        if (gridView.getVisibility() != 0) {
            gridView2 = this.a.Y;
            gridView2.setVisibility(0);
        }
    }
}
