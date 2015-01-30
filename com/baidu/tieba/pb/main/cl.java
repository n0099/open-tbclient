package com.baidu.tieba.pb.main;

import android.widget.ImageView;
import android.widget.RelativeLayout;
/* loaded from: classes.dex */
class cl implements Runnable {
    private final /* synthetic */ ImageView bED;
    final /* synthetic */ ck bEE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cl(ck ckVar, ImageView imageView) {
        this.bEE = ckVar;
        this.bED = imageView;
    }

    @Override // java.lang.Runnable
    public void run() {
        bz bzVar;
        RelativeLayout relativeLayout;
        bzVar = this.bEE.bEC;
        relativeLayout = bzVar.arb;
        relativeLayout.removeView(this.bED);
    }
}
