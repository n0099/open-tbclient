package com.baidu.tieba.write.album;

import android.widget.HorizontalScrollView;
/* loaded from: classes.dex */
class w implements Runnable {
    final /* synthetic */ t gdf;
    private final /* synthetic */ HorizontalScrollView gdh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(t tVar, HorizontalScrollView horizontalScrollView) {
        this.gdf = tVar;
        this.gdh = horizontalScrollView;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.gdh.fullScroll(66);
    }
}
