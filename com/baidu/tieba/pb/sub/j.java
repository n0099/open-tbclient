package com.baidu.tieba.pb.sub;

import android.view.View;
import com.baidu.tbadk.core.view.NavigationBar;
/* loaded from: classes.dex */
class j implements Runnable {
    final /* synthetic */ i bEq;
    private final /* synthetic */ View ns;
    private final /* synthetic */ int val$position;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(i iVar, int i, View view) {
        this.bEq = iVar;
        this.val$position = i;
        this.ns = view;
    }

    @Override // java.lang.Runnable
    public void run() {
        NavigationBar navigationBar;
        int[] iArr = new int[2];
        this.bEq.aBE.getLocationInWindow(iArr);
        int height = iArr[1] - this.ns.getHeight();
        navigationBar = this.bEq.mNavigationBar;
        this.bEq.mListView.setSelectionFromTop(this.val$position + 1, height - navigationBar.getHeight());
        this.bEq.mListView.invalidate();
    }
}
