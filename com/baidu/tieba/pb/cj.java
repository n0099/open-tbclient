package com.baidu.tieba.pb;

import android.widget.GridView;
/* loaded from: classes.dex */
class cj implements Runnable {
    final /* synthetic */ ch a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cj(ch chVar) {
        this.a = chVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        bl blVar;
        GridView gridView;
        blVar = this.a.a;
        gridView = blVar.I;
        gridView.setVisibility(8);
    }
}
