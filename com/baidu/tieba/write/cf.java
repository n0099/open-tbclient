package com.baidu.tieba.write;

import android.view.View;
/* loaded from: classes.dex */
class cf implements View.OnClickListener {
    final /* synthetic */ WriteMultiImgsActivity chx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cf(WriteMultiImgsActivity writeMultiImgsActivity) {
        this.chx = writeMultiImgsActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.chx.setResult(0);
        this.chx.finish();
    }
}
