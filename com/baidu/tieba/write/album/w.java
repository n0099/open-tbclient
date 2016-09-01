package com.baidu.tieba.write.album;

import android.widget.HorizontalScrollView;
/* loaded from: classes.dex */
class w implements Runnable {
    final /* synthetic */ t gaW;
    private final /* synthetic */ HorizontalScrollView gaY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(t tVar, HorizontalScrollView horizontalScrollView) {
        this.gaW = tVar;
        this.gaY = horizontalScrollView;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.gaY.fullScroll(66);
    }
}
