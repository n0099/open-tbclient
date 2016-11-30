package com.baidu.tieba.pb.pb.main;

import android.view.ViewStub;
import android.widget.LinearLayout;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class fa implements Runnable {
    final /* synthetic */ ey eCT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fa(ey eyVar) {
        this.eCT = eyVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        LinearLayout linearLayout;
        ViewStub viewStub;
        linearLayout = this.eCT.eBb;
        if (linearLayout == null) {
            this.eCT.aRP();
        }
        viewStub = this.eCT.eAA;
        viewStub.setVisibility(0);
    }
}
