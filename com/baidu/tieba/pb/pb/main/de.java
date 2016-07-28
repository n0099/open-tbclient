package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class de implements Runnable {
    final /* synthetic */ dd ecZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public de(dd ddVar) {
        this.ecZ = ddVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.adp.lib.guide.d dVar;
        View view;
        com.baidu.adp.lib.guide.d dVar2;
        com.baidu.adp.lib.guide.d dVar3;
        dVar = this.ecZ.ecW;
        if (dVar == null && this.ecZ.bem != null) {
            String string = this.ecZ.bem.getResources().getString(u.j.graffiti_pb_bottom_tips);
            if (!StringUtils.isNull(string)) {
                com.baidu.adp.lib.guide.g gVar = new com.baidu.adp.lib.guide.g();
                view = this.ecZ.ecX;
                gVar.o(view).Q(0).w(true).x(true);
                gVar.a(new df(this, string));
                this.ecZ.ecW = gVar.cV();
                dVar2 = this.ecZ.ecW;
                dVar2.u(false);
                dVar3 = this.ecZ.ecW;
                dVar3.f(this.ecZ.bem.getPageContext().getPageActivity());
                com.baidu.adp.lib.h.h.dL().postDelayed(new dg(this), 3000L);
            }
        }
    }
}
