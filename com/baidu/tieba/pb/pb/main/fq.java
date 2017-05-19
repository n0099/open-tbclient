package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.widget.ListView.BdTypeListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class fq implements Runnable {
    final /* synthetic */ fm epr;
    private final /* synthetic */ boolean eps;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fq(fm fmVar, boolean z) {
        this.epr = fmVar;
        this.eps = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        BdTypeListView bdTypeListView;
        bdTypeListView = this.epr.mListView;
        bdTypeListView.setEnabled(this.eps);
    }
}
