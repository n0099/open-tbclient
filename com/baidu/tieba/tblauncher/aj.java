package com.baidu.tieba.tblauncher;

import android.os.Handler;
import android.widget.ImageView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aj implements Runnable {
    final /* synthetic */ ab fbT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(ab abVar) {
        this.fbT = abVar;
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
        dVar = this.fbT.EF;
        if (dVar == null) {
            mainTabActivity = this.fbT.fbI;
            String string = mainTabActivity.getPageContext().getPageActivity().getResources().getString(u.j.messge_tab_change_tip);
            if (!StringUtils.isNull(string)) {
                com.baidu.adp.lib.guide.g gVar = new com.baidu.adp.lib.guide.g();
                imageView = this.fbT.fbL;
                gVar.o(imageView).N(0).u(true).v(true);
                gVar.a(new ak(this, string));
                this.fbT.EF = gVar.cW();
                dVar2 = this.fbT.EF;
                dVar2.s(false);
                dVar3 = this.fbT.EF;
                mainTabActivity2 = this.fbT.fbI;
                dVar3.f(mainTabActivity2.getPageContext().getPageActivity());
                this.fbT.fbO = true;
                this.fbT.WL();
                handler = this.fbT.mHandler;
                runnable = this.fbT.bFG;
                handler.postDelayed(runnable, 3000L);
            }
        }
    }
}
