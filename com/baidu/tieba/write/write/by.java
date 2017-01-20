package com.baidu.tieba.write.write;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class by implements View.OnClickListener {
    final /* synthetic */ WriteMultiImgsActivity fMR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public by(WriteMultiImgsActivity writeMultiImgsActivity) {
        this.fMR = writeMultiImgsActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        q qVar;
        qVar = this.fMR.fMA;
        qVar.tk(Integer.parseInt(view.getTag().toString()));
    }
}
