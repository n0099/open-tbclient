package com.baidu.tieba;

import android.widget.TextView;
/* loaded from: classes.dex */
class q implements Runnable {
    private final /* synthetic */ TextView aLV;
    final /* synthetic */ p aLW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(p pVar, TextView textView) {
        this.aLW = pVar;
        this.aLV = textView;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.aLV.setVisibility(0);
    }
}
