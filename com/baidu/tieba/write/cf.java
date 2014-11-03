package com.baidu.tieba.write;

import android.view.View;
/* loaded from: classes.dex */
class cf implements View.OnClickListener {
    final /* synthetic */ WriteMultiImgsActivity bUP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cf(WriteMultiImgsActivity writeMultiImgsActivity) {
        this.bUP = writeMultiImgsActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.bUP.setResult(0);
        this.bUP.finish();
    }
}
