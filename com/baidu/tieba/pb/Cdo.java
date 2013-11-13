package com.baidu.tieba.pb;

import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.baidu.tieba.pb.do  reason: invalid class name */
/* loaded from: classes.dex */
public class Cdo implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ boolean f2147a;
    final /* synthetic */ cp b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Cdo(cp cpVar, boolean z) {
        this.b = cpVar;
        this.f2147a = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        BdListView bdListView;
        bdListView = this.b.i;
        bdListView.setEnabled(this.f2147a);
    }
}
