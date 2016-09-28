package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class de implements Runnable {
    final /* synthetic */ dd erc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public de(dd ddVar) {
        this.erc = ddVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.adp.lib.guide.d dVar;
        View view;
        com.baidu.adp.lib.guide.d dVar2;
        com.baidu.adp.lib.guide.d dVar3;
        dVar = this.erc.eqZ;
        if (dVar == null && this.erc.aRd != null) {
            String string = this.erc.aRd.getResources().getString(r.j.graffiti_pb_bottom_tips);
            if (!StringUtils.isNull(string)) {
                com.baidu.adp.lib.guide.g gVar = new com.baidu.adp.lib.guide.g();
                view = this.erc.era;
                gVar.o(view).ad(0).y(true).z(true);
                gVar.a(new df(this, string));
                this.erc.eqZ = gVar.dQ();
                dVar2 = this.erc.eqZ;
                dVar2.w(false);
                dVar3 = this.erc.eqZ;
                dVar3.j(this.erc.aRd.getPageContext().getPageActivity());
                com.baidu.adp.lib.h.h.eG().postDelayed(new dg(this), 3000L);
            }
        }
    }
}
