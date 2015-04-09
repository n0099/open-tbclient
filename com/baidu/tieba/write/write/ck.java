package com.baidu.tieba.write.write;

import android.view.View;
/* loaded from: classes.dex */
class ck implements View.OnClickListener {
    final /* synthetic */ WriteMultiImgsActivity czb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ck(WriteMultiImgsActivity writeMultiImgsActivity) {
        this.czb = writeMultiImgsActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.czb.setResult(0);
        this.czb.finish();
    }
}
