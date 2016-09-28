package com.baidu.tieba.personPolymeric.d;

import android.view.View;
import android.widget.ImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y implements View.OnClickListener {
    com.baidu.tieba.personPolymeric.event.a eLJ = new com.baidu.tieba.personPolymeric.event.a();
    final /* synthetic */ x eLR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(x xVar) {
        this.eLR = xVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.view.m mVar;
        ImageView imageView;
        com.baidu.tieba.view.m mVar2;
        mVar = this.eLR.eFl;
        if (mVar != null) {
            imageView = this.eLR.eLO;
            if (imageView == view) {
                this.eLJ.bJq = 8;
            }
            mVar2 = this.eLR.eFl;
            mVar2.a(view, this.eLJ);
        }
    }
}
