package com.baidu.tieba.write.album;

import android.widget.HorizontalScrollView;
/* loaded from: classes.dex */
class w implements Runnable {
    final /* synthetic */ t eYA;
    private final /* synthetic */ HorizontalScrollView eYC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(t tVar, HorizontalScrollView horizontalScrollView) {
        this.eYA = tVar;
        this.eYC = horizontalScrollView;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.eYC.fullScroll(66);
    }
}
