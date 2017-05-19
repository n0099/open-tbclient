package com.baidu.tieba.pb.pb.main;

import android.view.ViewStub;
import android.widget.LinearLayout;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class fp implements Runnable {
    final /* synthetic */ fm epr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fp(fm fmVar) {
        this.epr = fmVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        LinearLayout linearLayout;
        ViewStub viewStub;
        linearLayout = this.epr.enz;
        if (linearLayout == null) {
            this.epr.aLr();
        }
        viewStub = this.epr.emV;
        viewStub.setVisibility(0);
    }
}
