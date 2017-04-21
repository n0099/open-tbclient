package com.baidu.tieba.write.album;

import android.widget.HorizontalScrollView;
/* loaded from: classes.dex */
class w implements Runnable {
    final /* synthetic */ t fQo;
    private final /* synthetic */ HorizontalScrollView fQq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(t tVar, HorizontalScrollView horizontalScrollView) {
        this.fQo = tVar;
        this.fQq = horizontalScrollView;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.fQq.fullScroll(66);
    }
}
