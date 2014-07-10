package com.baidu.tieba.topRec;

import android.view.View;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tieba.v;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements Runnable {
    final /* synthetic */ g a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(g gVar) {
        this.a = gVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        BdListView bdListView;
        BdListView bdListView2;
        n nVar;
        bdListView = this.a.c;
        if (bdListView.getChildCount() >= 3) {
            bdListView2 = this.a.c;
            View findViewById = bdListView2.getChildAt(2).findViewById(v.like);
            if (findViewById != null) {
                nVar = this.a.q;
                nVar.a(findViewById);
            }
        }
    }
}
