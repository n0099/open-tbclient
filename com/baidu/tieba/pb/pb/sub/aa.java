package com.baidu.tieba.pb.pb.sub;

import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aa implements Runnable {
    private final /* synthetic */ boolean cSB;
    final /* synthetic */ w cUl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(w wVar, boolean z) {
        this.cUl = wVar;
        this.cSB = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        BdListView bdListView;
        bdListView = this.cUl.IY;
        bdListView.setEnabled(this.cSB);
    }
}
