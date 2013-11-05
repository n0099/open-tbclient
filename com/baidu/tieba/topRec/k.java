package com.baidu.tieba.topRec;

import android.view.View;
import com.baidu.adp.widget.ListView.BdListView;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ h f2395a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(h hVar) {
        this.f2395a = hVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        BdListView bdListView;
        BdListView bdListView2;
        p pVar;
        bdListView = this.f2395a.b;
        if (bdListView.getChildCount() >= 3) {
            bdListView2 = this.f2395a.b;
            View findViewById = bdListView2.getChildAt(2).findViewById(R.id.like);
            if (findViewById != null) {
                pVar = this.f2395a.r;
                pVar.a(findViewById);
            }
        }
    }
}
