package com.baidu.tieba.pb;

import android.widget.GridView;
/* loaded from: classes.dex */
class cm implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ cl f1542a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cm(cl clVar) {
        this.f1542a = clVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        bo boVar;
        GridView gridView;
        bo boVar2;
        boVar = this.f1542a.f1541a;
        gridView = boVar.I;
        if (gridView.getVisibility() == 8) {
            boVar2 = this.f1542a.f1541a;
            boVar2.V();
        }
    }
}
