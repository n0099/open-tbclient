package com.baidu.tieba.write.write;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class by implements View.OnClickListener {
    final /* synthetic */ WriteMultiImgsActivity fSW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public by(WriteMultiImgsActivity writeMultiImgsActivity) {
        this.fSW = writeMultiImgsActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        q qVar;
        qVar = this.fSW.fSF;
        qVar.th(Integer.parseInt(view.getTag().toString()));
    }
}
