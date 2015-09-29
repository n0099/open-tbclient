package com.baidu.tieba.write.write;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class by implements View.OnClickListener {
    final /* synthetic */ WriteMultiImgsActivity dqm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public by(WriteMultiImgsActivity writeMultiImgsActivity) {
        this.dqm = writeMultiImgsActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        q qVar;
        qVar = this.dqm.dpW;
        qVar.mh(Integer.parseInt(view.getTag().toString()));
    }
}
