package com.baidu.tieba.write.album;

import android.widget.HorizontalScrollView;
/* loaded from: classes.dex */
class w implements Runnable {
    final /* synthetic */ t eHH;
    private final /* synthetic */ HorizontalScrollView eHJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(t tVar, HorizontalScrollView horizontalScrollView) {
        this.eHH = tVar;
        this.eHJ = horizontalScrollView;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.eHJ.fullScroll(66);
    }
}
