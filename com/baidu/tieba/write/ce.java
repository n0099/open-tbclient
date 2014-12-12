package com.baidu.tieba.write;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ce implements View.OnClickListener {
    final /* synthetic */ WriteMultiImgsActivity cfX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ce(WriteMultiImgsActivity writeMultiImgsActivity) {
        this.cfX = writeMultiImgsActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        r rVar;
        rVar = this.cfX.cfJ;
        rVar.in(Integer.parseInt(view.getTag().toString()));
    }
}
