package com.baidu.tieba.pb.main;

import android.widget.ImageView;
import android.widget.RelativeLayout;
/* loaded from: classes.dex */
class cm implements Runnable {
    private final /* synthetic */ ImageView byQ;
    final /* synthetic */ cl byR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cm(cl clVar, ImageView imageView) {
        this.byR = clVar;
        this.byQ = imageView;
    }

    @Override // java.lang.Runnable
    public void run() {
        bv bvVar;
        RelativeLayout relativeLayout;
        bvVar = this.byR.byI;
        relativeLayout = bvVar.ahN;
        relativeLayout.removeView(this.byQ);
    }
}
