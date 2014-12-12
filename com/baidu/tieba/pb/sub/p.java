package com.baidu.tieba.pb.sub;

import android.view.View;
/* loaded from: classes.dex */
class p implements Runnable {
    final /* synthetic */ l bEM;
    private final /* synthetic */ View ns;
    private final /* synthetic */ int val$position;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(l lVar, View view, int i) {
        this.bEM = lVar;
        this.ns = view;
        this.val$position = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.ns != null) {
            int[] iArr = new int[2];
            this.bEM.aBE.getLocationInWindow(iArr);
            this.bEM.mListView.setSelectionFromTop(this.val$position + 1, iArr[1] - this.ns.getHeight());
            this.bEM.mListView.invalidate();
        }
    }
}
