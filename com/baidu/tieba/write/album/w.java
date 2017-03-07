package com.baidu.tieba.write.album;

import android.widget.HorizontalScrollView;
/* loaded from: classes.dex */
class w implements Runnable {
    final /* synthetic */ t fMj;
    private final /* synthetic */ HorizontalScrollView fMl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(t tVar, HorizontalScrollView horizontalScrollView) {
        this.fMj = tVar;
        this.fMl = horizontalScrollView;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.fMl.fullScroll(66);
    }
}
