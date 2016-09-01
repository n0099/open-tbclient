package com.baidu.tieba.write.write;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cb implements View.OnClickListener {
    final /* synthetic */ WriteMultiImgsActivity ggd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cb(WriteMultiImgsActivity writeMultiImgsActivity) {
        this.ggd = writeMultiImgsActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.ggd.setResult(0);
        this.ggd.finish();
    }
}
