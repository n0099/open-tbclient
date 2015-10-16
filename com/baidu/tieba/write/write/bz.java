package com.baidu.tieba.write.write;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bz implements View.OnClickListener {
    final /* synthetic */ WriteMultiImgsActivity dqM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bz(WriteMultiImgsActivity writeMultiImgsActivity) {
        this.dqM = writeMultiImgsActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.dqM.setResult(0);
        this.dqM.finish();
    }
}
