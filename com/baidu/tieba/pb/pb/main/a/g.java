package com.baidu.tieba.pb.pb.main.a;

import android.os.Handler;
import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements Runnable {
    final /* synthetic */ f eht;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(f fVar) {
        this.eht = fVar;
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
        dVar = this.eht.Ht;
        if (dVar == null) {
            str = this.eht.mMessage;
            if (!StringUtils.isNull(str)) {
                com.baidu.adp.lib.guide.g gVar = new com.baidu.adp.lib.guide.g();
                view = this.eht.bL;
                gVar.o(view).ae(0).y(true).z(true);
                gVar.a(new h(this));
                this.eht.Ht = gVar.dQ();
                dVar2 = this.eht.Ht;
                dVar2.w(false);
                dVar3 = this.eht.Ht;
                tbPageContext = this.eht.GO;
                dVar3.j(tbPageContext.getPageActivity());
                this.eht.bxJ = true;
                this.eht.VX();
                handler = this.eht.mHandler;
                runnable = this.eht.bxM;
                handler.postDelayed(runnable, 3000L);
            }
        }
    }
}
