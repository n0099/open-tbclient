package com.baidu.tieba.pb.pb.sub;

import android.view.View;
import com.baidu.tbadk.core.view.NavigationBar;
/* loaded from: classes.dex */
class j implements Runnable {
    private final /* synthetic */ int Rz;
    final /* synthetic */ i bNZ;
    private final /* synthetic */ View yS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(i iVar, int i, View view) {
        this.bNZ = iVar;
        this.Rz = i;
        this.yS = view;
    }

    @Override // java.lang.Runnable
    public void run() {
        NavigationBar navigationBar;
        int[] iArr = new int[2];
        this.bNZ.aIG.getLocationInWindow(iArr);
        int height = iArr[1] - this.yS.getHeight();
        navigationBar = this.bNZ.mNavigationBar;
        this.bNZ.mListView.setSelectionFromTop(this.Rz + 1, height - navigationBar.getHeight());
        this.bNZ.mListView.invalidate();
    }
}
