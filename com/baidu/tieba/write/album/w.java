package com.baidu.tieba.write.album;

import android.widget.HorizontalScrollView;
/* loaded from: classes.dex */
class w implements Runnable {
    final /* synthetic */ t dTf;
    private final /* synthetic */ HorizontalScrollView dTh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(t tVar, HorizontalScrollView horizontalScrollView) {
        this.dTf = tVar;
        this.dTh = horizontalScrollView;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.dTh.fullScroll(66);
    }
}
