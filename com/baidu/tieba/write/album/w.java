package com.baidu.tieba.write.album;

import android.widget.HorizontalScrollView;
/* loaded from: classes.dex */
class w implements Runnable {
    final /* synthetic */ t fzm;
    private final /* synthetic */ HorizontalScrollView fzo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(t tVar, HorizontalScrollView horizontalScrollView) {
        this.fzm = tVar;
        this.fzo = horizontalScrollView;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.fzo.fullScroll(66);
    }
}
