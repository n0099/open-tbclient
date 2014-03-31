package com.baidu.tieba.mention;

import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class s implements Runnable {
    final /* synthetic */ m a;
    private final /* synthetic */ int b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(m mVar, int i) {
        this.a = mVar;
        this.b = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        BdListView bdListView;
        bdListView = this.a.e;
        bdListView.setSelection(this.b);
    }
}
