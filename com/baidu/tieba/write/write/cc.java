package com.baidu.tieba.write.write;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cc implements View.OnClickListener {
    final /* synthetic */ WriteMultiImgsActivity eNN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cc(WriteMultiImgsActivity writeMultiImgsActivity) {
        this.eNN = writeMultiImgsActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.eNN.setResult(0);
        this.eNN.finish();
    }
}
