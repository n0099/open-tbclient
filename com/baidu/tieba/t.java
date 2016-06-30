package com.baidu.tieba;

import android.widget.TextView;
/* loaded from: classes.dex */
class t implements Runnable {
    private final /* synthetic */ TextView aHC;
    final /* synthetic */ s aHD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(s sVar, TextView textView) {
        this.aHD = sVar;
        this.aHC = textView;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.aHC.setVisibility(0);
    }
}
