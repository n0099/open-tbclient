package com.baidu.tieba.pb;

import android.widget.GridView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bo implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ bn f1483a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bo(bn bnVar) {
        this.f1483a = bnVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        GridView gridView;
        this.f1483a.V();
        gridView = this.f1483a.H;
        gridView.setVisibility(0);
    }
}
