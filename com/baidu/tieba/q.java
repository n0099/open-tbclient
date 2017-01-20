package com.baidu.tieba;

import android.widget.TextView;
/* loaded from: classes.dex */
class q implements Runnable {
    private final /* synthetic */ TextView aKo;
    final /* synthetic */ p aKp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(p pVar, TextView textView) {
        this.aKp = pVar;
        this.aKo = textView;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.aKo.setVisibility(0);
    }
}
