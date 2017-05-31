package com.baidu.tieba.personPolymeric.d;

import android.view.View;
import android.widget.ImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ad implements View.OnClickListener {
    com.baidu.tieba.personPolymeric.event.a bxk = new com.baidu.tieba.personPolymeric.event.a();
    final /* synthetic */ ac eOh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(ac acVar) {
        this.eOh = acVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.view.r rVar;
        ImageView imageView;
        com.baidu.tieba.view.r rVar2;
        rVar = this.eOh.bxW;
        if (rVar != null) {
            imageView = this.eOh.bwV;
            if (imageView == view) {
                this.bxk.bOi = 8;
            }
            rVar2 = this.eOh.bxW;
            rVar2.a(view, this.bxk);
        }
    }
}
