package com.baidu.tieba.write.write;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cb implements View.OnClickListener {
    final /* synthetic */ WriteMultiImgsActivity gmv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cb(WriteMultiImgsActivity writeMultiImgsActivity) {
        this.gmv = writeMultiImgsActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.gmv.setResult(0);
        this.gmv.finish();
    }
}
