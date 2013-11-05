package com.baidu.tieba.pb;

import android.widget.GridView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cg implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ bt f2094a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cg(bt btVar) {
        this.f2094a = btVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        GridView gridView;
        this.f2094a.ak();
        gridView = this.f2094a.M;
        gridView.setVisibility(0);
    }
}
