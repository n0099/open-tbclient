package com.baidu.tieba;

import android.widget.TextView;
/* loaded from: classes.dex */
class s implements Runnable {
    private final /* synthetic */ TextView aKP;
    final /* synthetic */ r aKQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(r rVar, TextView textView) {
        this.aKQ = rVar;
        this.aKP = textView;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.aKP.setVisibility(0);
    }
}
