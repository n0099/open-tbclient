package com.baidu.tieba.write.album;

import android.widget.HorizontalScrollView;
/* loaded from: classes.dex */
class w implements Runnable {
    final /* synthetic */ t fNS;
    private final /* synthetic */ HorizontalScrollView fNU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(t tVar, HorizontalScrollView horizontalScrollView) {
        this.fNS = tVar;
        this.fNU = horizontalScrollView;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.fNU.fullScroll(66);
    }
}
