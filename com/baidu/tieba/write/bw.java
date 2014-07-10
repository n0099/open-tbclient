package com.baidu.tieba.write;

import android.view.View;
/* loaded from: classes.dex */
class bw implements View.OnClickListener {
    final /* synthetic */ WriteMultiImgsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bw(WriteMultiImgsActivity writeMultiImgsActivity) {
        this.a = writeMultiImgsActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.a.setResult(0);
        this.a.finish();
    }
}
