package com.baidu.tieba.pb.pb.main;

import android.view.ViewStub;
import android.widget.LinearLayout;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class fd implements Runnable {
    final /* synthetic */ ez eqf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fd(ez ezVar) {
        this.eqf = ezVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        LinearLayout linearLayout;
        ViewStub viewStub;
        linearLayout = this.eqf.eoo;
        if (linearLayout == null) {
            this.eqf.aNx();
        }
        viewStub = this.eqf.enN;
        viewStub.setVisibility(0);
    }
}
