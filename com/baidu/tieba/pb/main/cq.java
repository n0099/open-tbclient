package com.baidu.tieba.pb.main;

import android.widget.ImageView;
import android.widget.RelativeLayout;
/* loaded from: classes.dex */
class cq implements Runnable {
    private final /* synthetic */ ImageView bDa;
    final /* synthetic */ cp bDb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cq(cp cpVar, ImageView imageView) {
        this.bDb = cpVar;
        this.bDa = imageView;
    }

    @Override // java.lang.Runnable
    public void run() {
        bz bzVar;
        RelativeLayout relativeLayout;
        bzVar = this.bDb.bCR;
        relativeLayout = bzVar.apl;
        relativeLayout.removeView(this.bDa);
    }
}
