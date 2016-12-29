package com.baidu.tieba;

import android.widget.TextView;
/* loaded from: classes.dex */
class q implements Runnable {
    private final /* synthetic */ TextView aLm;
    final /* synthetic */ p aLn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(p pVar, TextView textView) {
        this.aLn = pVar;
        this.aLm = textView;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.aLm.setVisibility(0);
    }
}
