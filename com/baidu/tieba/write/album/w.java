package com.baidu.tieba.write.album;

import android.widget.HorizontalScrollView;
/* loaded from: classes.dex */
class w implements Runnable {
    final /* synthetic */ t fQR;
    private final /* synthetic */ HorizontalScrollView fQT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(t tVar, HorizontalScrollView horizontalScrollView) {
        this.fQR = tVar;
        this.fQT = horizontalScrollView;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.fQT.fullScroll(66);
    }
}
