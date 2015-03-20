package com.baidu.tieba.pb.pb.main;

import android.app.Activity;
import android.widget.RelativeLayout;
/* loaded from: classes.dex */
class cx implements Runnable {
    final /* synthetic */ cw bMs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cx(cw cwVar) {
        this.bMs = cwVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        ci ciVar;
        PbActivity pbActivity;
        ci ciVar2;
        RelativeLayout relativeLayout;
        ciVar = this.bMs.bMm;
        pbActivity = ciVar.bIF;
        Activity pageActivity = pbActivity.getPageContext().getPageActivity();
        ciVar2 = this.bMs.bMm;
        relativeLayout = ciVar2.bEy;
        com.baidu.adp.lib.util.n.c(pageActivity, relativeLayout);
    }
}
