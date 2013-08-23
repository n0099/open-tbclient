package com.baidu.tieba.pb;

import android.widget.GridView;
/* loaded from: classes.dex */
class co implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ cl f1544a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public co(cl clVar) {
        this.f1544a = clVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        bo boVar;
        GridView gridView;
        boVar = this.f1544a.f1541a;
        gridView = boVar.I;
        gridView.setVisibility(8);
    }
}
