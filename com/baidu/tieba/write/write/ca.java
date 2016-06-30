package com.baidu.tieba.write.write;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ca implements View.OnClickListener {
    final /* synthetic */ WriteMultiImgsActivity fKh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ca(WriteMultiImgsActivity writeMultiImgsActivity) {
        this.fKh = writeMultiImgsActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        r rVar;
        rVar = this.fKh.fJQ;
        rVar.sB(Integer.parseInt(view.getTag().toString()));
    }
}
