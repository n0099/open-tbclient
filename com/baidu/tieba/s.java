package com.baidu.tieba;

import android.widget.TextView;
/* loaded from: classes.dex */
class s implements Runnable {
    private final /* synthetic */ TextView aHa;
    final /* synthetic */ r aHb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(r rVar, TextView textView) {
        this.aHb = rVar;
        this.aHa = textView;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.aHa.setVisibility(0);
    }
}
