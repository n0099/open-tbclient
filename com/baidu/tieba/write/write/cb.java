package com.baidu.tieba.write.write;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cb implements View.OnClickListener {
    final /* synthetic */ WriteMultiImgsActivity eNN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cb(WriteMultiImgsActivity writeMultiImgsActivity) {
        this.eNN = writeMultiImgsActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        r rVar;
        rVar = this.eNN.eNx;
        rVar.qQ(Integer.parseInt(view.getTag().toString()));
    }
}
