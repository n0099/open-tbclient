package com.baidu.tieba.write;

import android.view.View;
/* loaded from: classes.dex */
class cf implements View.OnClickListener {
    final /* synthetic */ WriteMultiImgsActivity chw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cf(WriteMultiImgsActivity writeMultiImgsActivity) {
        this.chw = writeMultiImgsActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.chw.setResult(0);
        this.chw.finish();
    }
}
