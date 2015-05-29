package com.baidu.tieba.pb.pb.sub;

import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class af implements Runnable {
    private final /* synthetic */ boolean bOG;
    final /* synthetic */ s bPT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(s sVar, boolean z) {
        this.bPT = sVar;
        this.bOG = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        BdListView bdListView;
        bdListView = this.bPT.mListView;
        bdListView.setEnabled(this.bOG);
    }
}
