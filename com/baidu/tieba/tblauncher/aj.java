package com.baidu.tieba.tblauncher;

import android.os.Handler;
import android.widget.ImageView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aj implements Runnable {
    final /* synthetic */ ab fzu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(ab abVar) {
        this.fzu = abVar;
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
        dVar = this.fzu.Hs;
        if (dVar == null) {
            mainTabActivity = this.fzu.fzj;
            String string = mainTabActivity.getPageContext().getPageActivity().getResources().getString(r.j.messge_tab_change_tip);
            if (!StringUtils.isNull(string)) {
                com.baidu.adp.lib.guide.g gVar = new com.baidu.adp.lib.guide.g();
                imageView = this.fzu.fzm;
                gVar.o(imageView).ad(0).y(true).z(true);
                gVar.a(new ak(this, string));
                this.fzu.Hs = gVar.dQ();
                dVar2 = this.fzu.Hs;
                dVar2.w(false);
                dVar3 = this.fzu.Hs;
                mainTabActivity2 = this.fzu.fzj;
                dVar3.j(mainTabActivity2.getPageContext().getPageActivity());
                this.fzu.fzp = true;
                this.fzu.acn();
                handler = this.fzu.mHandler;
                runnable = this.fzu.bRT;
                handler.postDelayed(runnable, 3000L);
            }
        }
    }
}
