package com.baidu.tieba.write.album;

import android.widget.HorizontalScrollView;
/* loaded from: classes.dex */
class u implements Runnable {
    final /* synthetic */ r cQJ;
    private final /* synthetic */ HorizontalScrollView cQL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(r rVar, HorizontalScrollView horizontalScrollView) {
        this.cQJ = rVar;
        this.cQL = horizontalScrollView;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.cQL.fullScroll(66);
    }
}
