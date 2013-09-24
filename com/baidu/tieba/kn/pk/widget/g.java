package com.baidu.tieba.kn.pk.widget;

import android.widget.Scroller;
import java.util.ArrayList;
import java.util.Iterator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ e f1304a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(e eVar) {
        this.f1304a = eVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        Scroller scroller;
        Scroller scroller2;
        ArrayList arrayList;
        int i;
        scroller = this.f1304a.l;
        if (scroller.computeScrollOffset()) {
            e eVar = this.f1304a;
            scroller2 = this.f1304a.l;
            eVar.j = scroller2.getCurrX();
            arrayList = this.f1304a.n;
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                i = this.f1304a.j;
                ((a) it.next()).a(i);
            }
            this.f1304a.post(this);
        }
    }
}
