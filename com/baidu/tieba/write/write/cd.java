package com.baidu.tieba.write.write;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cd implements View.OnClickListener {
    final /* synthetic */ WriteMultiImgsActivity gbx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cd(WriteMultiImgsActivity writeMultiImgsActivity) {
        this.gbx = writeMultiImgsActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.gbx.setResult(0);
        this.gbx.finish();
    }
}
