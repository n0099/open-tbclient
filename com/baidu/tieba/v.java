package com.baidu.tieba;

import android.widget.TextView;
/* loaded from: classes.dex */
class v implements Runnable {
    private final /* synthetic */ TextView aQs;
    final /* synthetic */ u aQt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(u uVar, TextView textView) {
        this.aQt = uVar;
        this.aQs = textView;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.aQs.setVisibility(0);
    }
}
