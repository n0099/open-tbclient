package com.baidu.tieba.pb;

import android.widget.GridView;
/* loaded from: classes.dex */
class ci implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ch f1253a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ci(ch chVar) {
        this.f1253a = chVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        bk bkVar;
        GridView gridView;
        bk bkVar2;
        bkVar = this.f1253a.f1252a;
        gridView = bkVar.H;
        if (gridView.getVisibility() == 8) {
            bkVar2 = this.f1253a.f1252a;
            bkVar2.U();
        }
    }
}
