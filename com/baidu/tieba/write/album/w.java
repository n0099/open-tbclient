package com.baidu.tieba.write.album;

import android.widget.HorizontalScrollView;
/* loaded from: classes.dex */
class w implements Runnable {
    final /* synthetic */ t cuB;
    private final /* synthetic */ HorizontalScrollView cuD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(t tVar, HorizontalScrollView horizontalScrollView) {
        this.cuB = tVar;
        this.cuD = horizontalScrollView;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.cuD.fullScroll(66);
    }
}
