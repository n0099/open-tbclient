package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class de implements Runnable {
    final /* synthetic */ dd epe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public de(dd ddVar) {
        this.epe = ddVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.adp.lib.guide.d dVar;
        View view;
        com.baidu.adp.lib.guide.d dVar2;
        com.baidu.adp.lib.guide.d dVar3;
        dVar = this.epe.epb;
        if (dVar == null && this.epe.aPR != null) {
            String string = this.epe.aPR.getResources().getString(t.j.graffiti_pb_bottom_tips);
            if (!StringUtils.isNull(string)) {
                com.baidu.adp.lib.guide.g gVar = new com.baidu.adp.lib.guide.g();
                view = this.epe.epc;
                gVar.o(view).ad(0).y(true).z(true);
                gVar.a(new df(this, string));
                this.epe.epb = gVar.dQ();
                dVar2 = this.epe.epb;
                dVar2.w(false);
                dVar3 = this.epe.epb;
                dVar3.j(this.epe.aPR.getPageContext().getPageActivity());
                com.baidu.adp.lib.h.h.eG().postDelayed(new dg(this), 3000L);
            }
        }
    }
}
