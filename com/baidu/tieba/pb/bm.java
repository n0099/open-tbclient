package com.baidu.tieba.pb;

import android.widget.GridView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bm implements Runnable {
    final /* synthetic */ bl a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bm(bl blVar) {
        this.a = blVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        GridView gridView;
        this.a.U();
        gridView = this.a.I;
        gridView.setVisibility(0);
    }
}
