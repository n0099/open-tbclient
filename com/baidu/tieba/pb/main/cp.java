package com.baidu.tieba.pb.main;

import android.widget.ImageView;
import android.widget.RelativeLayout;
/* loaded from: classes.dex */
class cp implements Runnable {
    private final /* synthetic */ ImageView bEK;
    final /* synthetic */ co bEL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cp(co coVar, ImageView imageView) {
        this.bEL = coVar;
        this.bEK = imageView;
    }

    @Override // java.lang.Runnable
    public void run() {
        bz bzVar;
        RelativeLayout relativeLayout;
        bzVar = this.bEL.bEC;
        relativeLayout = bzVar.arb;
        relativeLayout.removeView(this.bEK);
    }
}
