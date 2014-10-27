package com.baidu.tieba.pb.sub;

import android.view.View;
import com.baidu.tbadk.core.view.NavigationBar;
/* loaded from: classes.dex */
class j implements Runnable {
    private final /* synthetic */ int BF;
    final /* synthetic */ i bAp;
    private final /* synthetic */ View nt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(i iVar, int i, View view) {
        this.bAp = iVar;
        this.BF = i;
        this.nt = view;
    }

    @Override // java.lang.Runnable
    public void run() {
        NavigationBar navigationBar;
        int[] iArr = new int[2];
        this.bAp.azA.getLocationInWindow(iArr);
        int height = iArr[1] - this.nt.getHeight();
        navigationBar = this.bAp.mNavigationBar;
        this.bAp.vl.setSelectionFromTop(this.BF + 1, height - navigationBar.getHeight());
        this.bAp.vl.invalidate();
    }
}
