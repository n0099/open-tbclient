package com.baidu.tieba.topRec;

import android.view.View;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tieba.v;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements Runnable {
    final /* synthetic */ h a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(h hVar) {
        this.a = hVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        BdListView bdListView;
        BdListView bdListView2;
        o oVar;
        bdListView = this.a.c;
        if (bdListView.getChildCount() >= 3) {
            bdListView2 = this.a.c;
            View findViewById = bdListView2.getChildAt(2).findViewById(v.like);
            if (findViewById != null) {
                oVar = this.a.q;
                oVar.a(findViewById);
            }
        }
    }
}
