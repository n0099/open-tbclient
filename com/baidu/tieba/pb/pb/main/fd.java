package com.baidu.tieba.pb.pb.main;

import android.view.ViewStub;
import android.widget.LinearLayout;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class fd implements Runnable {
    final /* synthetic */ fa etn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fd(fa faVar) {
        this.etn = faVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        LinearLayout linearLayout;
        ViewStub viewStub;
        linearLayout = this.etn.err;
        if (linearLayout == null) {
            this.etn.aMQ();
        }
        viewStub = this.etn.eqP;
        viewStub.setVisibility(0);
    }
}
