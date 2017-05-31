package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.widget.ListView.BdTypeListView;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class dc implements Runnable {
    final /* synthetic */ cv eod;
    private final /* synthetic */ List eog;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dc(cv cvVar, List list) {
        this.eod = cvVar;
        this.eog = list;
    }

    @Override // java.lang.Runnable
    public void run() {
        BdTypeListView bdTypeListView;
        BdTypeListView bdTypeListView2;
        bdTypeListView = this.eod.mListView;
        bdTypeListView2 = this.eod.mListView;
        bdTypeListView.setSelection(bdTypeListView2.getHeaderViewsCount() + this.eog.size());
        this.eod.enX = false;
    }
}
