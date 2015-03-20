package com.baidu.tieba.write.write;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cj implements View.OnClickListener {
    final /* synthetic */ WriteMultiImgsActivity cyF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cj(WriteMultiImgsActivity writeMultiImgsActivity) {
        this.cyF = writeMultiImgsActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        v vVar;
        vVar = this.cyF.cys;
        vVar.jd(Integer.parseInt(view.getTag().toString()));
    }
}
