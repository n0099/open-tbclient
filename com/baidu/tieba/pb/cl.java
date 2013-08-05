package com.baidu.tieba.pb;

import android.widget.GridView;
/* loaded from: classes.dex */
class cl implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ck f1506a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cl(ck ckVar) {
        this.f1506a = ckVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        bn bnVar;
        GridView gridView;
        bn bnVar2;
        bnVar = this.f1506a.f1505a;
        gridView = bnVar.H;
        if (gridView.getVisibility() == 8) {
            bnVar2 = this.f1506a.f1505a;
            bnVar2.U();
        }
    }
}
