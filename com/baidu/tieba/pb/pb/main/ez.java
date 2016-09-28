package com.baidu.tieba.pb.pb.main;

import android.view.ViewStub;
import android.widget.LinearLayout;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ez implements Runnable {
    final /* synthetic */ ex ewH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ez(ex exVar) {
        this.ewH = exVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        LinearLayout linearLayout;
        ViewStub viewStub;
        linearLayout = this.ewH.euO;
        if (linearLayout == null) {
            this.ewH.aPK();
        }
        viewStub = this.ewH.euj;
        viewStub.setVisibility(0);
    }
}
