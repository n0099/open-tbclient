package com.baidu.tieba.pb;

import android.widget.GridView;
/* loaded from: classes.dex */
class cn implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ck f1508a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cn(ck ckVar) {
        this.f1508a = ckVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        bn bnVar;
        GridView gridView;
        bnVar = this.f1508a.f1505a;
        gridView = bnVar.H;
        gridView.setVisibility(8);
    }
}
