package com.baidu.tieba.pb.pb.main;

import android.view.ViewStub;
import android.widget.LinearLayout;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class gc implements Runnable {
    final /* synthetic */ fx evi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public gc(fx fxVar) {
        this.evi = fxVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        LinearLayout linearLayout;
        ViewStub viewStub;
        linearLayout = this.evi.eto;
        if (linearLayout == null) {
            this.evi.aMn();
        }
        viewStub = this.evi.esJ;
        viewStub.setVisibility(0);
    }
}
