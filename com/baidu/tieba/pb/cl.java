package com.baidu.tieba.pb;

import android.widget.GridView;
/* loaded from: classes.dex */
class cl implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ck f1504a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cl(ck ckVar) {
        this.f1504a = ckVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        bn bnVar;
        GridView gridView;
        bn bnVar2;
        bnVar = this.f1504a.f1503a;
        gridView = bnVar.H;
        if (gridView.getVisibility() == 8) {
            bnVar2 = this.f1504a.f1503a;
            bnVar2.U();
        }
    }
}
