package com.baidu.tieba;

import android.widget.TextView;
/* loaded from: classes.dex */
class m implements Runnable {
    private final /* synthetic */ TextView aGR;
    final /* synthetic */ l aGS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(l lVar, TextView textView) {
        this.aGS = lVar;
        this.aGR = textView;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.aGR.setVisibility(0);
    }
}
