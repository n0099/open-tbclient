package com.baidu.tieba.pb.pb.main;

import android.app.Activity;
import android.widget.RelativeLayout;
/* loaded from: classes.dex */
class cy implements Runnable {
    final /* synthetic */ cx bMI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cy(cx cxVar) {
        this.bMI = cxVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        cj cjVar;
        PbActivity pbActivity;
        cj cjVar2;
        RelativeLayout relativeLayout;
        cjVar = this.bMI.bMC;
        pbActivity = cjVar.bIT;
        Activity pageActivity = pbActivity.getPageContext().getPageActivity();
        cjVar2 = this.bMI.bMC;
        relativeLayout = cjVar2.bEL;
        com.baidu.adp.lib.util.n.c(pageActivity, relativeLayout);
    }
}
