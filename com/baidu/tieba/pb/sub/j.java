package com.baidu.tieba.pb.sub;

import android.view.View;
import com.baidu.tbadk.core.view.NavigationBar;
/* loaded from: classes.dex */
class j implements Runnable {
    private final /* synthetic */ int FS;
    final /* synthetic */ i bGa;
    private final /* synthetic */ View nv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(i iVar, int i, View view) {
        this.bGa = iVar;
        this.FS = i;
        this.nv = view;
    }

    @Override // java.lang.Runnable
    public void run() {
        NavigationBar navigationBar;
        int[] iArr = new int[2];
        this.bGa.aCC.getLocationInWindow(iArr);
        int height = iArr[1] - this.nv.getHeight();
        navigationBar = this.bGa.mNavigationBar;
        this.bGa.mListView.setSelectionFromTop(this.FS + 1, height - navigationBar.getHeight());
        this.bGa.mListView.invalidate();
    }
}
