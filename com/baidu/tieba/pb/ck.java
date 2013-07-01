package com.baidu.tieba.pb;

import android.widget.GridView;
/* loaded from: classes.dex */
class ck implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ch f1255a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ck(ch chVar) {
        this.f1255a = chVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        bk bkVar;
        GridView gridView;
        bkVar = this.f1255a.f1252a;
        gridView = bkVar.H;
        gridView.setVisibility(8);
    }
}
