package com.baidu.tieba.topRec;

import android.view.View;
import com.baidu.adp.widget.ListView.BdListView;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ h f1873a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(h hVar) {
        this.f1873a = hVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        BdListView bdListView;
        BdListView bdListView2;
        o oVar;
        bdListView = this.f1873a.b;
        if (bdListView.getChildCount() >= 3) {
            bdListView2 = this.f1873a.b;
            View findViewById = bdListView2.getChildAt(2).findViewById(R.id.like);
            if (findViewById != null) {
                oVar = this.f1873a.r;
                oVar.a(findViewById);
            }
        }
    }
}
