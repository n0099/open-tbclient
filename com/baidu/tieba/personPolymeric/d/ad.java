package com.baidu.tieba.personPolymeric.d;

import android.view.View;
import android.widget.ImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ad implements View.OnClickListener {
    com.baidu.tieba.personPolymeric.event.a eYi = new com.baidu.tieba.personPolymeric.event.a();
    final /* synthetic */ ac eYx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(ac acVar) {
        this.eYx = acVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.view.r rVar;
        ImageView imageView;
        com.baidu.tieba.view.r rVar2;
        rVar = this.eYx.eRa;
        if (rVar != null) {
            imageView = this.eYx.bzJ;
            if (imageView == view) {
                this.eYi.bVd = 8;
            }
            rVar2 = this.eYx.eRa;
            rVar2.a(view, this.eYi);
        }
    }
}
