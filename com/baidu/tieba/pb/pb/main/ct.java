package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ct implements Runnable {
    final /* synthetic */ cs dkT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ct(cs csVar) {
        this.dkT = csVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.adp.lib.guide.d dVar;
        View view;
        com.baidu.adp.lib.guide.d dVar2;
        com.baidu.adp.lib.guide.d dVar3;
        dVar = this.dkT.dkQ;
        if (dVar == null && this.dkT.bek != null) {
            String string = this.dkT.bek.getResources().getString(t.j.graffiti_pb_bottom_tips);
            if (!StringUtils.isNull(string)) {
                com.baidu.adp.lib.guide.g gVar = new com.baidu.adp.lib.guide.g();
                view = this.dkT.dkR;
                gVar.o(view).N(0).u(true).v(true);
                gVar.a(new cu(this, string));
                this.dkT.dkQ = gVar.cV();
                dVar2 = this.dkT.dkQ;
                dVar2.s(false);
                dVar3 = this.dkT.dkQ;
                dVar3.d(this.dkT.bek.getPageContext().getPageActivity());
                com.baidu.adp.lib.h.h.dL().postDelayed(new cv(this), 3000L);
            }
        }
    }
}
