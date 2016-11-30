package com.baidu.tieba.pb.pb.main.a;

import android.os.Handler;
import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements Runnable {
    final /* synthetic */ f eDr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(f fVar) {
        this.eDr = fVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.adp.lib.guide.d dVar;
        String str;
        View view;
        com.baidu.adp.lib.guide.d dVar2;
        com.baidu.adp.lib.guide.d dVar3;
        TbPageContext tbPageContext;
        Handler handler;
        Runnable runnable;
        dVar = this.eDr.Hu;
        if (dVar == null) {
            str = this.eDr.mMessage;
            if (!StringUtils.isNull(str)) {
                com.baidu.adp.lib.guide.g gVar = new com.baidu.adp.lib.guide.g();
                view = this.eDr.bL;
                gVar.o(view).ad(0).y(true).z(true);
                gVar.a(new h(this));
                this.eDr.Hu = gVar.dQ();
                dVar2 = this.eDr.Hu;
                dVar2.w(false);
                dVar3 = this.eDr.Hu;
                tbPageContext = this.eDr.GO;
                dVar3.j(tbPageContext.getPageActivity());
                this.eDr.eDn = true;
                this.eDr.aSI();
                handler = this.eDr.mHandler;
                runnable = this.eDr.eDq;
                handler.postDelayed(runnable, 3000L);
            }
        }
    }
}
