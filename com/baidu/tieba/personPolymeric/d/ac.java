package com.baidu.tieba.personPolymeric.d;

import android.view.View;
import android.widget.ImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac implements View.OnClickListener {
    com.baidu.tieba.personPolymeric.event.a eFh = new com.baidu.tieba.personPolymeric.event.a();
    final /* synthetic */ ab eFx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(ab abVar) {
        this.eFx = abVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.view.p pVar;
        ImageView imageView;
        com.baidu.tieba.view.p pVar2;
        pVar = this.eFx.eyy;
        if (pVar != null) {
            imageView = this.eFx.bAU;
            if (imageView == view) {
                this.eFh.bIu = 8;
            }
            pVar2 = this.eFx.eyy;
            pVar2.a(view, this.eFh);
        }
    }
}
