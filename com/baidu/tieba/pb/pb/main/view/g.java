package com.baidu.tieba.pb.pb.main.view;

import android.view.animation.AlphaAnimation;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements Runnable {
    final /* synthetic */ PbFloorAgreeView eGD;
    private final /* synthetic */ AlphaAnimation eGE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(PbFloorAgreeView pbFloorAgreeView, AlphaAnimation alphaAnimation) {
        this.eGD = pbFloorAgreeView;
        this.eGE = alphaAnimation;
    }

    @Override // java.lang.Runnable
    public void run() {
        TextView textView;
        textView = this.eGD.eGA;
        textView.startAnimation(this.eGE);
    }
}
