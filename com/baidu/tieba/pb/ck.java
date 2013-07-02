package com.baidu.tieba.pb;

import android.widget.GridView;
/* loaded from: classes.dex */
class ck implements Runnable {
    final /* synthetic */ ch a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ck(ch chVar) {
        this.a = chVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        bk bkVar;
        GridView gridView;
        bkVar = this.a.a;
        gridView = bkVar.H;
        gridView.setVisibility(8);
    }
}
