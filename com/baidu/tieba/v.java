package com.baidu.tieba;

import android.widget.TextView;
/* loaded from: classes.dex */
class v implements Runnable {
    private final /* synthetic */ TextView aQq;
    final /* synthetic */ u aQr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(u uVar, TextView textView) {
        this.aQr = uVar;
        this.aQq = textView;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.aQq.setVisibility(0);
    }
}
