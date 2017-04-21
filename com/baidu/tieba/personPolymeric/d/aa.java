package com.baidu.tieba.personPolymeric.d;

import android.view.View;
import android.widget.ImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aa implements View.OnClickListener {
    com.baidu.tieba.personPolymeric.event.a eJs = new com.baidu.tieba.personPolymeric.event.a();
    final /* synthetic */ z eJz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(z zVar) {
        this.eJz = zVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.view.m mVar;
        ImageView imageView;
        com.baidu.tieba.view.m mVar2;
        mVar = this.eJz.eCN;
        if (mVar != null) {
            imageView = this.eJz.bAT;
            if (imageView == view) {
                this.eJs.bJo = 8;
            }
            mVar2 = this.eJz.eCN;
            mVar2.a(view, this.eJs);
        }
    }
}
