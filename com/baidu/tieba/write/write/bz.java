package com.baidu.tieba.write.write;

import android.view.View;
/* loaded from: classes.dex */
class bz implements View.OnClickListener {
    final /* synthetic */ WriteMultiImgsActivity der;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bz(WriteMultiImgsActivity writeMultiImgsActivity) {
        this.der = writeMultiImgsActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.der.setResult(0);
        this.der.finish();
    }
}
