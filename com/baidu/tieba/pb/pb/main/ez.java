package com.baidu.tieba.pb.pb.main;

import android.view.ViewStub;
import android.widget.LinearLayout;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ez implements Runnable {
    final /* synthetic */ ex euB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ez(ex exVar) {
        this.euB = exVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        LinearLayout linearLayout;
        ViewStub viewStub;
        linearLayout = this.euB.esF;
        if (linearLayout == null) {
            this.euB.aPb();
        }
        viewStub = this.euB.esa;
        viewStub.setVisibility(0);
    }
}
