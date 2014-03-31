package com.baidu.tieba.topRec;

import android.view.View;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.TbadkApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class k implements Runnable {
    final /* synthetic */ h a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(h hVar) {
        this.a = hVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        BdListView bdListView;
        BdListView bdListView2;
        o oVar;
        bdListView = this.a.c;
        if (bdListView.getChildCount() >= 3) {
            bdListView2 = this.a.c;
            View findViewById = bdListView2.getChildAt(2).findViewById(com.baidu.tieba.a.h.like);
            if (findViewById != null) {
                oVar = this.a.q;
                if (o.a() || TbadkApplication.j().l() != 0) {
                    return;
                }
                com.baidu.adp.lib.guide.g gVar = new com.baidu.adp.lib.guide.g();
                gVar.a(findViewById).a(150).b(true);
                p pVar = new p(oVar);
                gVar.a(pVar).a(new q(oVar));
                gVar.a().a(oVar.a);
                com.baidu.adp.lib.util.f.e("TOPRECTipCover", "show", "done");
                com.baidu.tbadk.core.sharedPref.b.a().b("toprec_first_in", true);
            }
        }
    }
}
