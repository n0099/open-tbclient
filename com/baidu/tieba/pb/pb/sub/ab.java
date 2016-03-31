package com.baidu.tieba.pb.pb.sub;

import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab implements Runnable {
    private final /* synthetic */ boolean dnd;
    final /* synthetic */ x dpf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(x xVar, boolean z) {
        this.dpf = xVar;
        this.dnd = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        BdListView bdListView;
        bdListView = this.dpf.Je;
        bdListView.setEnabled(this.dnd);
    }
}
