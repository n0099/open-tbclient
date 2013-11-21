package com.baidu.tieba.pb;

import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class dq implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ boolean f2132a;
    final /* synthetic */ cr b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dq(cr crVar, boolean z) {
        this.b = crVar;
        this.f2132a = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        BdListView bdListView;
        bdListView = this.b.i;
        bdListView.setEnabled(this.f2132a);
    }
}
