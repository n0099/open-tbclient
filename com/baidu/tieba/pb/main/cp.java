package com.baidu.tieba.pb.main;

import android.widget.ImageView;
import android.widget.RelativeLayout;
/* loaded from: classes.dex */
class cp implements Runnable {
    private final /* synthetic */ ImageView bEJ;
    final /* synthetic */ co bEK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cp(co coVar, ImageView imageView) {
        this.bEK = coVar;
        this.bEJ = imageView;
    }

    @Override // java.lang.Runnable
    public void run() {
        bz bzVar;
        RelativeLayout relativeLayout;
        bzVar = this.bEK.bEB;
        relativeLayout = bzVar.aqY;
        relativeLayout.removeView(this.bEJ);
    }
}
