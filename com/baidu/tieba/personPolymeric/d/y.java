package com.baidu.tieba.personPolymeric.d;

import android.view.View;
import android.widget.ImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y implements View.OnClickListener {
    com.baidu.tieba.personPolymeric.event.a evG = new com.baidu.tieba.personPolymeric.event.a();
    final /* synthetic */ x evO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(x xVar) {
        this.evO = xVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.view.m mVar;
        ImageView imageView;
        com.baidu.tieba.view.m mVar2;
        mVar = this.evO.epg;
        if (mVar != null) {
            imageView = this.evO.evL;
            if (imageView == view) {
                this.evG.bsn = 8;
            }
            mVar2 = this.evO.epg;
            mVar2.a(view, this.evG);
        }
    }
}
