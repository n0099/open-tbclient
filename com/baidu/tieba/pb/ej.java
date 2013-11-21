package com.baidu.tieba.pb;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ej implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ int f2149a;
    final /* synthetic */ View b;
    final /* synthetic */ ed c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ej(ed edVar, int i, View view) {
        this.c = edVar;
        this.f2149a = i;
        this.b = view;
    }

    @Override // java.lang.Runnable
    public void run() {
        int[] iArr = new int[2];
        this.c.I.getLocationInWindow(iArr);
        this.c.c.setSelectionFromTop(this.f2149a + 1, iArr[1] - this.b.getHeight());
        this.c.c.invalidate();
    }
}
