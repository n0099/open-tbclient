package com.baidu.tieba.write.write;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bx implements View.OnClickListener {
    final /* synthetic */ WriteMultiImgsActivity etW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bx(WriteMultiImgsActivity writeMultiImgsActivity) {
        this.etW = writeMultiImgsActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        q qVar;
        qVar = this.etW.etG;
        qVar.pW(Integer.parseInt(view.getTag().toString()));
    }
}
