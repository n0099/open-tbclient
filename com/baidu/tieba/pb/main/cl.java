package com.baidu.tieba.pb.main;

import android.widget.ImageView;
import android.widget.RelativeLayout;
/* loaded from: classes.dex */
class cl implements Runnable {
    private final /* synthetic */ ImageView bEC;
    final /* synthetic */ ck bED;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cl(ck ckVar, ImageView imageView) {
        this.bED = ckVar;
        this.bEC = imageView;
    }

    @Override // java.lang.Runnable
    public void run() {
        bz bzVar;
        RelativeLayout relativeLayout;
        bzVar = this.bED.bEB;
        relativeLayout = bzVar.aqY;
        relativeLayout.removeView(this.bEC);
    }
}
