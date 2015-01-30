package com.baidu.tieba.person;

import android.view.View;
/* loaded from: classes.dex */
class ap implements View.OnClickListener {
    final /* synthetic */ al bHX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ap(al alVar) {
        this.bHX = alVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        av avVar;
        z = this.bHX.bHU;
        if (!z) {
            al alVar = this.bHX;
            avVar = this.bHX.bHP;
            alVar.pageNum = avVar.getData().na().mW() + 1;
            this.bHX.bHU = true;
            this.bHX.aaY();
        }
    }
}
