package com.baidu.tieba.pb.pb.main;

import android.view.ViewStub;
import android.widget.LinearLayout;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ey implements Runnable {
    final /* synthetic */ ew eiu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ey(ew ewVar) {
        this.eiu = ewVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        LinearLayout linearLayout;
        ViewStub viewStub;
        linearLayout = this.eiu.egz;
        if (linearLayout == null) {
            this.eiu.aKk();
        }
        viewStub = this.eiu.efV;
        viewStub.setVisibility(0);
    }
}
