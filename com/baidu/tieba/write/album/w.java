package com.baidu.tieba.write.album;

import android.widget.HorizontalScrollView;
/* loaded from: classes.dex */
class w implements Runnable {
    final /* synthetic */ t cul;
    private final /* synthetic */ HorizontalScrollView cun;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(t tVar, HorizontalScrollView horizontalScrollView) {
        this.cul = tVar;
        this.cun = horizontalScrollView;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.cun.fullScroll(66);
    }
}
