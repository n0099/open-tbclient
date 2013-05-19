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
        bl blVar;
        GridView gridView;
        bl blVar2;
        blVar = this.a.a;
        gridView = blVar.I;
        if (gridView.getVisibility() == 8) {
            blVar2 = this.a.a;
            blVar2.T();
        }
    }
}
