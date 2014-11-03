package com.baidu.tieba.pb.main;

import android.widget.ImageView;
import android.widget.RelativeLayout;
/* loaded from: classes.dex */
class ci implements Runnable {
    private final /* synthetic */ ImageView byX;
    final /* synthetic */ ch byY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ci(ch chVar, ImageView imageView) {
        this.byY = chVar;
        this.byX = imageView;
    }

    @Override // java.lang.Runnable
    public void run() {
        bv bvVar;
        RelativeLayout relativeLayout;
        bvVar = this.byY.byW;
        relativeLayout = bvVar.ahW;
        relativeLayout.removeView(this.byX);
    }
}
