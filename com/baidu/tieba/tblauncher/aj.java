package com.baidu.tieba.tblauncher;

import android.os.Handler;
import android.widget.ImageView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aj implements Runnable {
    final /* synthetic */ ab foX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(ab abVar) {
        this.foX = abVar;
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
        dVar = this.foX.Ff;
        if (dVar == null) {
            mainTabActivity = this.foX.foM;
            String string = mainTabActivity.getPageContext().getPageActivity().getResources().getString(u.j.messge_tab_change_tip);
            if (!StringUtils.isNull(string)) {
                com.baidu.adp.lib.guide.g gVar = new com.baidu.adp.lib.guide.g();
                imageView = this.foX.foP;
                gVar.o(imageView).Q(0).w(true).x(true);
                gVar.a(new ak(this, string));
                this.foX.Ff = gVar.cV();
                dVar2 = this.foX.Ff;
                dVar2.u(false);
                dVar3 = this.foX.Ff;
                mainTabActivity2 = this.foX.foM;
                dVar3.f(mainTabActivity2.getPageContext().getPageActivity());
                this.foX.foS = true;
                this.foX.Xd();
                handler = this.foX.mHandler;
                runnable = this.foX.bGU;
                handler.postDelayed(runnable, 3000L);
            }
        }
    }
}
