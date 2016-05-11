package com.baidu.tieba.write.write;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ce implements View.OnClickListener {
    final /* synthetic */ WriteMultiImgsActivity feN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ce(WriteMultiImgsActivity writeMultiImgsActivity) {
        this.feN = writeMultiImgsActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        r rVar;
        rVar = this.feN.few;
        rVar.rl(Integer.parseInt(view.getTag().toString()));
    }
}
