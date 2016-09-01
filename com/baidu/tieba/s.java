package com.baidu.tieba;

import android.widget.TextView;
/* loaded from: classes.dex */
class s implements Runnable {
    private final /* synthetic */ TextView aLK;
    final /* synthetic */ r aLL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(r rVar, TextView textView) {
        this.aLL = rVar;
        this.aLK = textView;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.aLK.setVisibility(0);
    }
}
