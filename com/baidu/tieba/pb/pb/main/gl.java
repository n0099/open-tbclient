package com.baidu.tieba.pb.pb.main;

import android.view.ViewStub;
import android.widget.LinearLayout;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class gl implements Runnable {
    final /* synthetic */ gg eEv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public gl(gg ggVar) {
        this.eEv = ggVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        LinearLayout linearLayout;
        ViewStub viewStub;
        linearLayout = this.eEv.eCy;
        if (linearLayout == null) {
            this.eEv.aQl();
        }
        viewStub = this.eEv.eBU;
        viewStub.setVisibility(0);
    }
}
