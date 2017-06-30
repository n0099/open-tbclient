package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.widget.ListView.BdTypeListView;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class dj implements Runnable {
    final /* synthetic */ dc exj;
    private final /* synthetic */ List exl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dj(dc dcVar, List list) {
        this.exj = dcVar;
        this.exl = list;
    }

    @Override // java.lang.Runnable
    public void run() {
        BdTypeListView bdTypeListView;
        BdTypeListView bdTypeListView2;
        bdTypeListView = this.exj.mListView;
        bdTypeListView2 = this.exj.mListView;
        bdTypeListView.setSelection(bdTypeListView2.getHeaderViewsCount() + this.exl.size());
        this.exj.exd = false;
    }
}
