package com.baidu.tieba.pb.pb.main;

import android.widget.LinearLayout;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class en implements Runnable {
    final /* synthetic */ el dpu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public en(el elVar) {
        this.dpu = elVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        LinearLayout linearLayout;
        linearLayout = this.dpu.dnB;
        linearLayout.setVisibility(0);
    }
}
