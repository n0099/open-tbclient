package com.baidu.tieba.personPolymeric.d;

import android.view.View;
import android.widget.ImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y implements View.OnClickListener {
    com.baidu.tieba.personPolymeric.event.a eJG = new com.baidu.tieba.personPolymeric.event.a();
    final /* synthetic */ x eJO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(x xVar) {
        this.eJO = xVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.view.m mVar;
        ImageView imageView;
        com.baidu.tieba.view.m mVar2;
        mVar = this.eJO.eDi;
        if (mVar != null) {
            imageView = this.eJO.eJL;
            if (imageView == view) {
                this.eJG.bJp = 8;
            }
            mVar2 = this.eJO.eDi;
            mVar2.a(view, this.eJG);
        }
    }
}
