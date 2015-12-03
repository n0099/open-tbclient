package com.baidu.tieba;

import android.widget.TextView;
/* loaded from: classes.dex */
class m implements Runnable {
    private final /* synthetic */ TextView aFr;
    final /* synthetic */ l aFs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(l lVar, TextView textView) {
        this.aFs = lVar;
        this.aFr = textView;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.aFr.setVisibility(0);
    }
}
