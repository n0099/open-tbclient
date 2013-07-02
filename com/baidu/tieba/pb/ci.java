package com.baidu.tieba.pb;

import android.widget.GridView;
/* loaded from: classes.dex */
class ci implements Runnable {
    final /* synthetic */ ch a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ci(ch chVar) {
        this.a = chVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        bk bkVar;
        GridView gridView;
        bk bkVar2;
        bkVar = this.a.a;
        gridView = bkVar.H;
        if (gridView.getVisibility() == 8) {
            bkVar2 = this.a.a;
            bkVar2.U();
        }
    }
}
