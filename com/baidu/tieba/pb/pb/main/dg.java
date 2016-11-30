package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class dg implements Runnable {
    final /* synthetic */ df ewU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dg(df dfVar) {
        this.ewU = dfVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.adp.lib.guide.d dVar;
        View view;
        com.baidu.adp.lib.guide.d dVar2;
        com.baidu.adp.lib.guide.d dVar3;
        dVar = this.ewU.ewQ;
        if (dVar == null && this.ewU.aTb != null) {
            String string = this.ewU.aTb.getResources().getString(r.j.graffiti_pb_bottom_tips);
            if (!StringUtils.isNull(string)) {
                com.baidu.adp.lib.guide.g gVar = new com.baidu.adp.lib.guide.g();
                view = this.ewU.ewR;
                gVar.o(view).ad(0).y(true).z(true);
                gVar.a(new dh(this, string));
                this.ewU.ewQ = gVar.dQ();
                dVar2 = this.ewU.ewQ;
                dVar2.w(false);
                dVar3 = this.ewU.ewQ;
                dVar3.j(this.ewU.aTb.getPageContext().getPageActivity());
                com.baidu.adp.lib.h.h.eG().postDelayed(new di(this), 3000L);
            }
        }
    }
}
