package com.baidu.tieba.pb.sub;

import android.view.View;
import com.baidu.tbadk.core.view.NavigationBar;
/* loaded from: classes.dex */
class j implements Runnable {
    private final /* synthetic */ int FV;
    final /* synthetic */ i bGb;
    private final /* synthetic */ View nv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(i iVar, int i, View view) {
        this.bGb = iVar;
        this.FV = i;
        this.nv = view;
    }

    @Override // java.lang.Runnable
    public void run() {
        NavigationBar navigationBar;
        int[] iArr = new int[2];
        this.bGb.aCF.getLocationInWindow(iArr);
        int height = iArr[1] - this.nv.getHeight();
        navigationBar = this.bGb.mNavigationBar;
        this.bGb.mListView.setSelectionFromTop(this.FV + 1, height - navigationBar.getHeight());
        this.bGb.mListView.invalidate();
    }
}
