package com.baidu.tieba.pb.sub;

import android.view.View;
import com.baidu.tbadk.core.view.NavigationBar;
/* loaded from: classes.dex */
class j implements Runnable {
    final /* synthetic */ i a;
    private final /* synthetic */ int b;
    private final /* synthetic */ View c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(i iVar, int i, View view) {
        this.a = iVar;
        this.b = i;
        this.c = view;
    }

    @Override // java.lang.Runnable
    public void run() {
        NavigationBar navigationBar;
        int[] iArr = new int[2];
        this.a.M.getLocationInWindow(iArr);
        int height = iArr[1] - this.c.getHeight();
        navigationBar = this.a.S;
        this.a.d.setSelectionFromTop(this.b + 1, height - navigationBar.getHeight());
        this.a.d.invalidate();
    }
}
