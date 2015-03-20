package com.baidu.tieba.write.write;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cl implements View.OnClickListener {
    final /* synthetic */ WriteMultiImgsActivity cyF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cl(WriteMultiImgsActivity writeMultiImgsActivity) {
        this.cyF = writeMultiImgsActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.cyF.ars();
    }
}
