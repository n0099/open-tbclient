package com.baidu.tieba.pb;

import android.widget.GridView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class co implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ br f1586a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public co(br brVar) {
        this.f1586a = brVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        GridView gridView;
        this.f1586a.ak();
        gridView = this.f1586a.M;
        gridView.setVisibility(0);
    }
}
