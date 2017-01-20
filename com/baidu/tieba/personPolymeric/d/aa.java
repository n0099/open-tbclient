package com.baidu.tieba.personPolymeric.d;

import android.view.View;
import android.widget.ImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aa implements View.OnClickListener {
    com.baidu.tieba.personPolymeric.event.a eFF = new com.baidu.tieba.personPolymeric.event.a();
    final /* synthetic */ z eFM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(z zVar) {
        this.eFM = zVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.view.m mVar;
        ImageView imageView;
        com.baidu.tieba.view.m mVar2;
        mVar = this.eFM.ezb;
        if (mVar != null) {
            imageView = this.eFM.brH;
            if (imageView == view) {
                this.eFF.bzY = 8;
            }
            mVar2 = this.eFM.ezb;
            mVar2.a(view, this.eFF);
        }
    }
}
