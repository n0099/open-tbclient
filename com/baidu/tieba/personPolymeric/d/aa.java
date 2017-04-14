package com.baidu.tieba.personPolymeric.d;

import android.view.View;
import android.widget.ImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aa implements View.OnClickListener {
    com.baidu.tieba.personPolymeric.event.a eHc = new com.baidu.tieba.personPolymeric.event.a();
    final /* synthetic */ z eHj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(z zVar) {
        this.eHj = zVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.view.m mVar;
        ImageView imageView;
        com.baidu.tieba.view.m mVar2;
        mVar = this.eHj.eAx;
        if (mVar != null) {
            imageView = this.eHj.byC;
            if (imageView == view) {
                this.eHc.bGX = 8;
            }
            mVar2 = this.eHj.eAx;
            mVar2.a(view, this.eHc);
        }
    }
}
