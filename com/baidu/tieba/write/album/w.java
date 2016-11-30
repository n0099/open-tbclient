package com.baidu.tieba.write.album;

import android.widget.HorizontalScrollView;
/* loaded from: classes.dex */
class w implements Runnable {
    final /* synthetic */ t gkK;
    private final /* synthetic */ HorizontalScrollView gkM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(t tVar, HorizontalScrollView horizontalScrollView) {
        this.gkK = tVar;
        this.gkM = horizontalScrollView;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.gkM.fullScroll(66);
    }
}
