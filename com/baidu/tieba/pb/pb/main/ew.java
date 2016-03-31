package com.baidu.tieba.pb.pb.main;

import android.widget.LinearLayout;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ew implements Runnable {
    final /* synthetic */ eu dnc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ew(eu euVar) {
        this.dnc = euVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        LinearLayout linearLayout;
        linearLayout = this.dnc.dlf;
        linearLayout.setVisibility(0);
    }
}
