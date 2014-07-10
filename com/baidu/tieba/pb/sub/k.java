package com.baidu.tieba.pb.sub;

import android.view.View;
import com.baidu.tbadk.core.view.NavigationBar;
/* loaded from: classes.dex */
class k implements Runnable {
    final /* synthetic */ j a;
    private final /* synthetic */ int b;
    private final /* synthetic */ View c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar, int i, View view) {
        this.a = jVar;
        this.b = i;
        this.c = view;
    }

    @Override // java.lang.Runnable
    public void run() {
        NavigationBar navigationBar;
        int[] iArr = new int[2];
        this.a.L.getLocationInWindow(iArr);
        int height = iArr[1] - this.c.getHeight();
        navigationBar = this.a.Q;
        this.a.d.setSelectionFromTop(this.b + 1, height - navigationBar.getHeight());
        this.a.d.invalidate();
    }
}
