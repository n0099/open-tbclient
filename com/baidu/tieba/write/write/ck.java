package com.baidu.tieba.write.write;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ck implements View.OnClickListener {
    final /* synthetic */ WriteMultiImgsActivity cDu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ck(WriteMultiImgsActivity writeMultiImgsActivity) {
        this.cDu = writeMultiImgsActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        w wVar;
        wVar = this.cDu.cDh;
        wVar.jC(Integer.parseInt(view.getTag().toString()));
    }
}
