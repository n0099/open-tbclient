package com.baidu.tieba.personPolymeric.d;

import android.view.View;
import android.widget.ImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y implements View.OnClickListener {
    com.baidu.tieba.personPolymeric.event.a eSh = new com.baidu.tieba.personPolymeric.event.a();
    final /* synthetic */ x eSp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(x xVar) {
        this.eSp = xVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.view.m mVar;
        ImageView imageView;
        com.baidu.tieba.view.m mVar2;
        mVar = this.eSp.eLK;
        if (mVar != null) {
            imageView = this.eSp.eSm;
            if (imageView == view) {
                this.eSh.bMj = 8;
            }
            mVar2 = this.eSp.eLK;
            mVar2.a(view, this.eSh);
        }
    }
}
