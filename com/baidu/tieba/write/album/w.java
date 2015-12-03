package com.baidu.tieba.write.album;

import android.widget.HorizontalScrollView;
/* loaded from: classes.dex */
class w implements Runnable {
    final /* synthetic */ t dLG;
    private final /* synthetic */ HorizontalScrollView dLI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(t tVar, HorizontalScrollView horizontalScrollView) {
        this.dLG = tVar;
        this.dLI = horizontalScrollView;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.dLI.fullScroll(66);
    }
}
