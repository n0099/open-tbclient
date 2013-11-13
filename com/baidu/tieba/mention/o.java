package com.baidu.tieba.mention;

import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ int f1867a;
    final /* synthetic */ j b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(j jVar, int i) {
        this.b = jVar;
        this.f1867a = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        BdListView bdListView;
        bdListView = this.b.e;
        bdListView.setSelection(this.f1867a);
    }
}
