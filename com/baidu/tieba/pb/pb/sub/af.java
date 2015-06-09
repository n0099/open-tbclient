package com.baidu.tieba.pb.pb.sub;

import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class af implements Runnable {
    private final /* synthetic */ boolean bOH;
    final /* synthetic */ s bPU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(s sVar, boolean z) {
        this.bPU = sVar;
        this.bOH = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        BdListView bdListView;
        bdListView = this.bPU.mListView;
        bdListView.setEnabled(this.bOH);
    }
}
