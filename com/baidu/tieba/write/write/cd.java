package com.baidu.tieba.write.write;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cd implements View.OnClickListener {
    final /* synthetic */ WriteMultiImgsActivity fTB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cd(WriteMultiImgsActivity writeMultiImgsActivity) {
        this.fTB = writeMultiImgsActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.fTB.setResult(0);
        this.fTB.finish();
    }
}
