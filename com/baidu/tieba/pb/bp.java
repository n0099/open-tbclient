package com.baidu.tieba.pb;

import android.widget.GridView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bp implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ bo f1519a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bp(bo boVar) {
        this.f1519a = boVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        GridView gridView;
        this.f1519a.W();
        gridView = this.f1519a.I;
        gridView.setVisibility(0);
    }
}
