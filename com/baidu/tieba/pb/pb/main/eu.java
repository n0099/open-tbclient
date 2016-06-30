package com.baidu.tieba.pb.pb.main;

import android.view.ViewStub;
import android.widget.LinearLayout;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class eu implements Runnable {
    final /* synthetic */ es dVR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public eu(es esVar) {
        this.dVR = esVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        LinearLayout linearLayout;
        ViewStub viewStub;
        linearLayout = this.dVR.dTY;
        if (linearLayout == null) {
            this.dVR.aGX();
        }
        viewStub = this.dVR.dTt;
        viewStub.setVisibility(0);
    }
}
