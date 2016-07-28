package com.baidu.tieba;

import android.widget.TextView;
/* loaded from: classes.dex */
class t implements Runnable {
    private final /* synthetic */ TextView aIt;
    final /* synthetic */ s aIu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(s sVar, TextView textView) {
        this.aIu = sVar;
        this.aIt = textView;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.aIt.setVisibility(0);
    }
}
