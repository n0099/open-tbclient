package com.baidu.tieba.write;

import android.view.View;
/* loaded from: classes.dex */
class cf implements View.OnClickListener {
    final /* synthetic */ WriteMultiImgsActivity cfX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cf(WriteMultiImgsActivity writeMultiImgsActivity) {
        this.cfX = writeMultiImgsActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.cfX.setResult(0);
        this.cfX.finish();
    }
}
