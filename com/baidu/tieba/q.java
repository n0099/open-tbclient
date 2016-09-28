package com.baidu.tieba;

import android.widget.TextView;
/* loaded from: classes.dex */
class q implements Runnable {
    private final /* synthetic */ TextView aLe;
    final /* synthetic */ p aLf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(p pVar, TextView textView) {
        this.aLf = pVar;
        this.aLe = textView;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.aLe.setVisibility(0);
    }
}
