package com.baidu.tieba.pb.pb.main;

import android.view.ViewStub;
import android.widget.LinearLayout;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class fb implements Runnable {
    final /* synthetic */ ey etN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fb(ey eyVar) {
        this.etN = eyVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        LinearLayout linearLayout;
        ViewStub viewStub;
        linearLayout = this.etN.erR;
        if (linearLayout == null) {
            this.etN.aOa();
        }
        viewStub = this.etN.erp;
        viewStub.setVisibility(0);
    }
}
