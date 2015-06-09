package com.baidu.tieba.write.write;

import android.view.View;
/* loaded from: classes.dex */
class cl implements View.OnClickListener {
    final /* synthetic */ WriteMultiImgsActivity cDu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cl(WriteMultiImgsActivity writeMultiImgsActivity) {
        this.cDu = writeMultiImgsActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.cDu.setResult(0);
        this.cDu.finish();
    }
}
