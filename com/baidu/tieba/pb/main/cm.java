package com.baidu.tieba.pb.main;

import android.widget.ImageView;
import android.widget.RelativeLayout;
/* loaded from: classes.dex */
class cm implements Runnable {
    private final /* synthetic */ ImageView bze;
    final /* synthetic */ cl bzf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cm(cl clVar, ImageView imageView) {
        this.bzf = clVar;
        this.bze = imageView;
    }

    @Override // java.lang.Runnable
    public void run() {
        bv bvVar;
        RelativeLayout relativeLayout;
        bvVar = this.bzf.byW;
        relativeLayout = bvVar.ahW;
        relativeLayout.removeView(this.bze);
    }
}
