package com.baidu.tieba.write.write;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bw implements View.OnClickListener {
    final /* synthetic */ WriteMultiImgsActivity cVn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bw(WriteMultiImgsActivity writeMultiImgsActivity) {
        this.cVn = writeMultiImgsActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.cVn.avr();
    }
}
