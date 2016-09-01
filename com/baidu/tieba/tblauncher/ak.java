package com.baidu.tieba.tblauncher;

import android.os.Handler;
import android.widget.ImageView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ak implements Runnable {
    final /* synthetic */ ac fwR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(ac acVar) {
        this.fwR = acVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.adp.lib.guide.d dVar;
        MainTabActivity mainTabActivity;
        ImageView imageView;
        com.baidu.adp.lib.guide.d dVar2;
        com.baidu.adp.lib.guide.d dVar3;
        MainTabActivity mainTabActivity2;
        Handler handler;
        Runnable runnable;
        dVar = this.fwR.Hs;
        if (dVar == null) {
            mainTabActivity = this.fwR.fwG;
            String string = mainTabActivity.getPageContext().getPageActivity().getResources().getString(t.j.messge_tab_change_tip);
            if (!StringUtils.isNull(string)) {
                com.baidu.adp.lib.guide.g gVar = new com.baidu.adp.lib.guide.g();
                imageView = this.fwR.fwJ;
                gVar.o(imageView).ad(0).y(true).z(true);
                gVar.a(new al(this, string));
                this.fwR.Hs = gVar.dQ();
                dVar2 = this.fwR.Hs;
                dVar2.w(false);
                dVar3 = this.fwR.Hs;
                mainTabActivity2 = this.fwR.fwG;
                dVar3.j(mainTabActivity2.getPageContext().getPageActivity());
                this.fwR.fwM = true;
                this.fwR.aca();
                handler = this.fwR.mHandler;
                runnable = this.fwR.bSa;
                handler.postDelayed(runnable, 3000L);
            }
        }
    }
}
