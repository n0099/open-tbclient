package com.baidu.tieba.pb.main;

import android.widget.ImageView;
import android.widget.RelativeLayout;
/* loaded from: classes.dex */
class cm implements Runnable {
    private final /* synthetic */ ImageView bCT;
    final /* synthetic */ cl bCU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cm(cl clVar, ImageView imageView) {
        this.bCU = clVar;
        this.bCT = imageView;
    }

    @Override // java.lang.Runnable
    public void run() {
        bz bzVar;
        RelativeLayout relativeLayout;
        bzVar = this.bCU.bCR;
        relativeLayout = bzVar.apl;
        relativeLayout.removeView(this.bCT);
    }
}
