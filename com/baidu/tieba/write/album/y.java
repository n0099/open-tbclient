package com.baidu.tieba.write.album;

import android.widget.HorizontalScrollView;
/* loaded from: classes.dex */
class y implements Runnable {
    final /* synthetic */ v cyU;
    private final /* synthetic */ HorizontalScrollView cyW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(v vVar, HorizontalScrollView horizontalScrollView) {
        this.cyU = vVar;
        this.cyW = horizontalScrollView;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.cyW.fullScroll(66);
    }
}
