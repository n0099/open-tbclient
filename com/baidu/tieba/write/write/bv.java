package com.baidu.tieba.write.write;

import android.view.View;
/* loaded from: classes.dex */
class bv implements View.OnClickListener {
    final /* synthetic */ WriteMultiImgsActivity cVn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bv(WriteMultiImgsActivity writeMultiImgsActivity) {
        this.cVn = writeMultiImgsActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.cVn.setResult(0);
        this.cVn.finish();
    }
}
