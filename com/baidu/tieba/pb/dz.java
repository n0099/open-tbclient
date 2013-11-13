package com.baidu.tieba.pb;

import android.view.View;
import com.baidu.tieba.view.NavigationBar;
/* loaded from: classes.dex */
class dz implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ int f2155a;
    final /* synthetic */ View b;
    final /* synthetic */ dy c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dz(dy dyVar, int i, View view) {
        this.c = dyVar;
        this.f2155a = i;
        this.b = view;
    }

    @Override // java.lang.Runnable
    public void run() {
        NavigationBar navigationBar;
        int[] iArr = new int[2];
        this.c.I.getLocationInWindow(iArr);
        int height = iArr[1] - this.b.getHeight();
        navigationBar = this.c.N;
        this.c.c.setSelectionFromTop(this.f2155a + 1, height - navigationBar.getHeight());
        this.c.c.invalidate();
    }
}
