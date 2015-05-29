package com.baidu.tieba.write.album;

import android.widget.HorizontalScrollView;
/* loaded from: classes.dex */
class y implements Runnable {
    final /* synthetic */ v cyT;
    private final /* synthetic */ HorizontalScrollView cyV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(v vVar, HorizontalScrollView horizontalScrollView) {
        this.cyT = vVar;
        this.cyV = horizontalScrollView;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.cyV.fullScroll(66);
    }
}
