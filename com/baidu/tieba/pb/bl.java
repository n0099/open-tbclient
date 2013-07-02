package com.baidu.tieba.pb;

import android.widget.GridView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bl implements Runnable {
    final /* synthetic */ bk a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bl(bk bkVar) {
        this.a = bkVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        GridView gridView;
        this.a.V();
        gridView = this.a.H;
        gridView.setVisibility(0);
    }
}
