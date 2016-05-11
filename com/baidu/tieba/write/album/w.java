package com.baidu.tieba.write.album;

import android.widget.HorizontalScrollView;
/* loaded from: classes.dex */
class w implements Runnable {
    final /* synthetic */ t eYB;
    private final /* synthetic */ HorizontalScrollView eYD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(t tVar, HorizontalScrollView horizontalScrollView) {
        this.eYB = tVar;
        this.eYD = horizontalScrollView;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.eYD.fullScroll(66);
    }
}
