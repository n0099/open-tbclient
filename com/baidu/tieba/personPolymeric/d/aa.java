package com.baidu.tieba.personPolymeric.d;

import android.view.View;
import android.widget.ImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aa implements View.OnClickListener {
    com.baidu.tieba.personPolymeric.event.a eJh = new com.baidu.tieba.personPolymeric.event.a();
    final /* synthetic */ z eJo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(z zVar) {
        this.eJo = zVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.view.m mVar;
        ImageView imageView;
        com.baidu.tieba.view.m mVar2;
        mVar = this.eJo.eCA;
        if (mVar != null) {
            imageView = this.eJo.byJ;
            if (imageView == view) {
                this.eJh.bHe = 8;
            }
            mVar2 = this.eJo.eCA;
            mVar2.a(view, this.eJh);
        }
    }
}
