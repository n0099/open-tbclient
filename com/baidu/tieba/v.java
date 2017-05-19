package com.baidu.tieba;

import android.widget.TextView;
/* loaded from: classes.dex */
class v implements Runnable {
    private final /* synthetic */ TextView aQL;
    final /* synthetic */ u aQM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(u uVar, TextView textView) {
        this.aQM = uVar;
        this.aQL = textView;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.aQL.setVisibility(0);
    }
}
