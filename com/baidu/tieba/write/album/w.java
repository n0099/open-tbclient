package com.baidu.tieba.write.album;

import android.widget.HorizontalScrollView;
/* loaded from: classes.dex */
class w implements Runnable {
    final /* synthetic */ t enK;
    private final /* synthetic */ HorizontalScrollView enM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(t tVar, HorizontalScrollView horizontalScrollView) {
        this.enK = tVar;
        this.enM = horizontalScrollView;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.enM.fullScroll(66);
    }
}
