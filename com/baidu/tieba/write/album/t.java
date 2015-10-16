package com.baidu.tieba.write.album;

import android.widget.HorizontalScrollView;
/* loaded from: classes.dex */
class t implements Runnable {
    final /* synthetic */ q dkS;
    private final /* synthetic */ HorizontalScrollView dkU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(q qVar, HorizontalScrollView horizontalScrollView) {
        this.dkS = qVar;
        this.dkU = horizontalScrollView;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.dkU.fullScroll(66);
    }
}
