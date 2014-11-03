package com.baidu.tieba.write;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cg implements View.OnClickListener {
    final /* synthetic */ WriteMultiImgsActivity bUP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cg(WriteMultiImgsActivity writeMultiImgsActivity) {
        this.bUP = writeMultiImgsActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.bUP.afK();
    }
}
