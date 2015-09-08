package com.baidu.tieba.write.album;

import android.widget.HorizontalScrollView;
/* loaded from: classes.dex */
class u implements Runnable {
    final /* synthetic */ r cZu;
    private final /* synthetic */ HorizontalScrollView cZw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(r rVar, HorizontalScrollView horizontalScrollView) {
        this.cZu = rVar;
        this.cZw = horizontalScrollView;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.cZw.fullScroll(66);
    }
}
