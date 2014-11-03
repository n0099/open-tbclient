package com.baidu.tieba.pb.sub;

import android.view.View;
import com.baidu.tbadk.core.view.NavigationBar;
/* loaded from: classes.dex */
class j implements Runnable {
    private final /* synthetic */ int BG;
    final /* synthetic */ i bAD;
    private final /* synthetic */ View nt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(i iVar, int i, View view) {
        this.bAD = iVar;
        this.BG = i;
        this.nt = view;
    }

    @Override // java.lang.Runnable
    public void run() {
        NavigationBar navigationBar;
        int[] iArr = new int[2];
        this.bAD.azJ.getLocationInWindow(iArr);
        int height = iArr[1] - this.nt.getHeight();
        navigationBar = this.bAD.mNavigationBar;
        this.bAD.vl.setSelectionFromTop(this.BG + 1, height - navigationBar.getHeight());
        this.bAD.vl.invalidate();
    }
}
