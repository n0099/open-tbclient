package com.baidu.tieba.topRec;

import android.view.View;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.cloudsdk.social.core.util.SocialAPIErrorCodes;
import com.baidu.tieba.TiebaApplication;
import com.slidingmenu.lib.R;
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
            View findViewById = bdListView2.getChildAt(2).findViewById(R.id.like);
            if (findViewById != null) {
                oVar = this.a.q;
                if (o.a() || TiebaApplication.g().ae() != 0) {
                    return;
                }
                com.baidu.adp.lib.guide.g gVar = new com.baidu.adp.lib.guide.g();
                gVar.a(findViewById).a(SocialAPIErrorCodes.ERROR_AUTHORIZATION_CANCELED).b(true);
                p pVar = new p(oVar);
                gVar.a(pVar).a(new q(oVar));
                gVar.a().a(oVar.a);
                com.baidu.adp.lib.util.e.e("TOPRECTipCover", "show", "done");
                com.baidu.tieba.sharedPref.b.a().b("toprec_first_in", true);
            }
        }
    }
}
