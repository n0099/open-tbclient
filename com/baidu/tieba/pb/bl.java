package com.baidu.tieba.pb;

import android.widget.GridView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bl implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ bk f1230a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bl(bk bkVar) {
        this.f1230a = bkVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        GridView gridView;
        this.f1230a.V();
        gridView = this.f1230a.H;
        gridView.setVisibility(0);
    }
}
