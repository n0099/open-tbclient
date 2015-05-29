package com.baidu.tieba.write.write;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cm implements View.OnClickListener {
    final /* synthetic */ WriteMultiImgsActivity cDt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cm(WriteMultiImgsActivity writeMultiImgsActivity) {
        this.cDt = writeMultiImgsActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.cDt.atx();
    }
}
