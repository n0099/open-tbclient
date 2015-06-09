package com.baidu.tieba.write.write;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cm implements View.OnClickListener {
    final /* synthetic */ WriteMultiImgsActivity cDu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cm(WriteMultiImgsActivity writeMultiImgsActivity) {
        this.cDu = writeMultiImgsActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.cDu.aty();
    }
}
