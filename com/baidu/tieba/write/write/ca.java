package com.baidu.tieba.write.write;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ca implements View.OnClickListener {
    final /* synthetic */ WriteMultiImgsActivity fVY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ca(WriteMultiImgsActivity writeMultiImgsActivity) {
        this.fVY = writeMultiImgsActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        r rVar;
        rVar = this.fVY.fVH;
        rVar.sP(Integer.parseInt(view.getTag().toString()));
    }
}
