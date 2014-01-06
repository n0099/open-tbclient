package com.baidu.tieba.pb;

import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ds implements Runnable {
    final /* synthetic */ boolean a;
    final /* synthetic */ cs b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ds(cs csVar, boolean z) {
        this.b = csVar;
        this.a = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        BdListView bdListView;
        bdListView = this.b.i;
        bdListView.setEnabled(this.a);
    }
}
