package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class dd implements Runnable {
    final /* synthetic */ dc dQK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dd(dc dcVar) {
        this.dQK = dcVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.adp.lib.guide.d dVar;
        View view;
        com.baidu.adp.lib.guide.d dVar2;
        com.baidu.adp.lib.guide.d dVar3;
        dVar = this.dQK.dQH;
        if (dVar == null && this.dQK.bkc != null) {
            String string = this.dQK.bkc.getResources().getString(u.j.graffiti_pb_bottom_tips);
            if (!StringUtils.isNull(string)) {
                com.baidu.adp.lib.guide.g gVar = new com.baidu.adp.lib.guide.g();
                view = this.dQK.dQI;
                gVar.o(view).N(0).u(true).v(true);
                gVar.a(new de(this, string));
                this.dQK.dQH = gVar.cW();
                dVar2 = this.dQK.dQH;
                dVar2.s(false);
                dVar3 = this.dQK.dQH;
                dVar3.f(this.dQK.bkc.getPageContext().getPageActivity());
                com.baidu.adp.lib.h.h.dM().postDelayed(new df(this), 3000L);
            }
        }
    }
}
