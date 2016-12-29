package com.baidu.tieba.pb.pb.main;

import android.view.ViewStub;
import android.widget.LinearLayout;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class et implements Runnable {
    final /* synthetic */ er egZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public et(er erVar) {
        this.egZ = erVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        LinearLayout linearLayout;
        ViewStub viewStub;
        linearLayout = this.egZ.efi;
        if (linearLayout == null) {
            this.egZ.aLJ();
        }
        viewStub = this.egZ.eeJ;
        viewStub.setVisibility(0);
    }
}
