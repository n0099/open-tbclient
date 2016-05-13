package com.baidu.tieba.write.write;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cf implements View.OnClickListener {
    final /* synthetic */ WriteMultiImgsActivity feM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cf(WriteMultiImgsActivity writeMultiImgsActivity) {
        this.feM = writeMultiImgsActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.feM.setResult(0);
        this.feM.finish();
    }
}
