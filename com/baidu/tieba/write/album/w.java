package com.baidu.tieba.write.album;

import android.widget.HorizontalScrollView;
/* loaded from: classes.dex */
class w implements Runnable {
    final /* synthetic */ t fDE;
    private final /* synthetic */ HorizontalScrollView fDG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(t tVar, HorizontalScrollView horizontalScrollView) {
        this.fDE = tVar;
        this.fDG = horizontalScrollView;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.fDG.fullScroll(66);
    }
}
