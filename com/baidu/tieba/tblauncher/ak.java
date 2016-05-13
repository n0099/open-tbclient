package com.baidu.tieba.tblauncher;

import android.os.Handler;
import android.widget.ImageView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ak implements Runnable {
    final /* synthetic */ ab exg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(ab abVar) {
        this.exg = abVar;
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
        dVar = this.exg.Ey;
        if (dVar == null) {
            mainTabActivity = this.exg.ewR;
            String string = mainTabActivity.getPageContext().getPageActivity().getResources().getString(t.j.messge_tab_change_tip);
            if (!StringUtils.isNull(string)) {
                com.baidu.adp.lib.guide.g gVar = new com.baidu.adp.lib.guide.g();
                imageView = this.exg.ewW;
                gVar.o(imageView).N(0).u(true).v(true);
                gVar.a(new al(this, string));
                this.exg.Ey = gVar.cV();
                dVar2 = this.exg.Ey;
                dVar2.s(false);
                dVar3 = this.exg.Ey;
                mainTabActivity2 = this.exg.ewR;
                dVar3.d(mainTabActivity2.getPageContext().getPageActivity());
                this.exg.ewZ = true;
                this.exg.aVM();
                handler = this.exg.mHandler;
                runnable = this.exg.exf;
                handler.postDelayed(runnable, 3000L);
            }
        }
    }
}
