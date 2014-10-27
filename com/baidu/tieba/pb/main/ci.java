package com.baidu.tieba.pb.main;

import android.widget.ImageView;
import android.widget.RelativeLayout;
/* loaded from: classes.dex */
class ci implements Runnable {
    private final /* synthetic */ ImageView byJ;
    final /* synthetic */ ch byK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ci(ch chVar, ImageView imageView) {
        this.byK = chVar;
        this.byJ = imageView;
    }

    @Override // java.lang.Runnable
    public void run() {
        bv bvVar;
        RelativeLayout relativeLayout;
        bvVar = this.byK.byI;
        relativeLayout = bvVar.ahN;
        relativeLayout.removeView(this.byJ);
    }
}
