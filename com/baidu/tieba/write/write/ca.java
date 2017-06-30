package com.baidu.tieba.write.write;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ca implements View.OnClickListener {
    final /* synthetic */ WriteMultiImgsActivity gmv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ca(WriteMultiImgsActivity writeMultiImgsActivity) {
        this.gmv = writeMultiImgsActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        q qVar;
        qVar = this.gmv.gme;
        qVar.ub(Integer.parseInt(view.getTag().toString()));
    }
}
