package com.baidu.tieba.pb.pb.main;

import android.view.ViewStub;
import android.widget.LinearLayout;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class fb implements Runnable {
    final /* synthetic */ ey erv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fb(ey eyVar) {
        this.erv = eyVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        LinearLayout linearLayout;
        ViewStub viewStub;
        linearLayout = this.erv.epA;
        if (linearLayout == null) {
            this.erv.aMZ();
        }
        viewStub = this.erv.eoY;
        viewStub.setVisibility(0);
    }
}
