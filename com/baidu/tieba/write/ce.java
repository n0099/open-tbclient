package com.baidu.tieba.write;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ce implements View.OnClickListener {
    final /* synthetic */ WriteMultiImgsActivity bUP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ce(WriteMultiImgsActivity writeMultiImgsActivity) {
        this.bUP = writeMultiImgsActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        r rVar;
        rVar = this.bUP.bUB;
        rVar.hF(Integer.parseInt(view.getTag().toString()));
    }
}
