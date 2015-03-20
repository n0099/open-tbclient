package com.baidu.tieba.pb.pb.sub;

import android.view.View;
import com.baidu.tbadk.core.view.NavigationBar;
/* loaded from: classes.dex */
class j implements Runnable {
    private final /* synthetic */ int Rx;
    final /* synthetic */ i bNJ;
    private final /* synthetic */ View yS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(i iVar, int i, View view) {
        this.bNJ = iVar;
        this.Rx = i;
        this.yS = view;
    }

    @Override // java.lang.Runnable
    public void run() {
        NavigationBar navigationBar;
        int[] iArr = new int[2];
        this.bNJ.aIy.getLocationInWindow(iArr);
        int height = iArr[1] - this.yS.getHeight();
        navigationBar = this.bNJ.mNavigationBar;
        this.bNJ.mListView.setSelectionFromTop(this.Rx + 1, height - navigationBar.getHeight());
        this.bNJ.mListView.invalidate();
    }
}
