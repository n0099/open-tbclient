package com.baidu.tieba.write.album;

import android.widget.HorizontalScrollView;
/* loaded from: classes.dex */
class w implements Runnable {
    final /* synthetic */ t fHP;
    private final /* synthetic */ HorizontalScrollView fHR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(t tVar, HorizontalScrollView horizontalScrollView) {
        this.fHP = tVar;
        this.fHR = horizontalScrollView;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.fHR.fullScroll(66);
    }
}
