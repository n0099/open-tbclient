package com.baidu.tieba;

import android.widget.TextView;
/* loaded from: classes.dex */
class v implements Runnable {
    private final /* synthetic */ TextView aQa;
    final /* synthetic */ u aQb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(u uVar, TextView textView) {
        this.aQb = uVar;
        this.aQa = textView;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.aQa.setVisibility(0);
    }
}
