package com.baidu.tieba.pb.pb.sub;

import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w implements Runnable {
    private final /* synthetic */ boolean clz;
    final /* synthetic */ t cmM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(t tVar, boolean z) {
        this.cmM = tVar;
        this.clz = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        BdListView bdListView;
        bdListView = this.cmM.mListView;
        bdListView.setEnabled(this.clz);
    }
}
