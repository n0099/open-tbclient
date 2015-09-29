package com.baidu.tieba.write.album;

import android.widget.HorizontalScrollView;
/* loaded from: classes.dex */
class t implements Runnable {
    final /* synthetic */ q dks;
    private final /* synthetic */ HorizontalScrollView dku;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(q qVar, HorizontalScrollView horizontalScrollView) {
        this.dks = qVar;
        this.dku = horizontalScrollView;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.dku.fullScroll(66);
    }
}
