package com.baidu.tieba;

import android.widget.TextView;
/* loaded from: classes.dex */
class s implements Runnable {
    private final /* synthetic */ TextView aHT;
    final /* synthetic */ r aHU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(r rVar, TextView textView) {
        this.aHU = rVar;
        this.aHT = textView;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.aHT.setVisibility(0);
    }
}
