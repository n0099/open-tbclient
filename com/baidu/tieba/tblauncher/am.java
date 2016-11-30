package com.baidu.tieba.tblauncher;

import android.os.Handler;
import android.widget.ImageView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class am implements Runnable {
    final /* synthetic */ ae fGW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(ae aeVar) {
        this.fGW = aeVar;
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
        dVar = this.fGW.Hu;
        if (dVar == null) {
            mainTabActivity = this.fGW.fGL;
            String string = mainTabActivity.getPageContext().getPageActivity().getResources().getString(r.j.messge_tab_change_tip);
            if (!StringUtils.isNull(string)) {
                com.baidu.adp.lib.guide.g gVar = new com.baidu.adp.lib.guide.g();
                imageView = this.fGW.fGO;
                gVar.o(imageView).ad(0).y(true).z(true);
                gVar.a(new an(this, string));
                this.fGW.Hu = gVar.dQ();
                dVar2 = this.fGW.Hu;
                dVar2.w(false);
                dVar3 = this.fGW.Hu;
                mainTabActivity2 = this.fGW.fGL;
                dVar3.j(mainTabActivity2.getPageContext().getPageActivity());
                this.fGW.fGR = true;
                this.fGW.bnU();
                handler = this.fGW.mHandler;
                runnable = this.fGW.eDq;
                handler.postDelayed(runnable, 3000L);
            }
        }
    }
}
