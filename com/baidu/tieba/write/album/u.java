package com.baidu.tieba.write.album;

import android.widget.HorizontalScrollView;
/* loaded from: classes.dex */
class u implements Runnable {
    final /* synthetic */ r dmA;
    private final /* synthetic */ HorizontalScrollView dmC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(r rVar, HorizontalScrollView horizontalScrollView) {
        this.dmA = rVar;
        this.dmC = horizontalScrollView;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.dmC.fullScroll(66);
    }
}
