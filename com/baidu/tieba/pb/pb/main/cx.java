package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.widget.ListView.BdTypeListView;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cx implements Runnable {
    final /* synthetic */ cq eiw;
    private final /* synthetic */ List eiy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cx(cq cqVar, List list) {
        this.eiw = cqVar;
        this.eiy = list;
    }

    @Override // java.lang.Runnable
    public void run() {
        BdTypeListView bdTypeListView;
        BdTypeListView bdTypeListView2;
        bdTypeListView = this.eiw.mListView;
        bdTypeListView2 = this.eiw.mListView;
        bdTypeListView.setSelection(bdTypeListView2.getHeaderViewsCount() + this.eiy.size());
    }
}
