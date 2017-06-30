package com.baidu.tieba;

import android.widget.TextView;
/* loaded from: classes.dex */
class v implements Runnable {
    private final /* synthetic */ TextView aSf;
    final /* synthetic */ u aSg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(u uVar, TextView textView) {
        this.aSg = uVar;
        this.aSf = textView;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.aSf.setVisibility(0);
    }
}
