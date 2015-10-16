package com.baidu.tieba.person;

import android.view.View;
/* loaded from: classes.dex */
class ba implements View.OnClickListener {
    final /* synthetic */ aw cqq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ba(aw awVar) {
        this.cqq = awVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        bf bfVar;
        z = this.cqq.cqm;
        if (!z) {
            aw awVar = this.cqq;
            bfVar = this.cqq.cqh;
            awVar.pageNum = bfVar.getData().getPage().rJ() + 1;
            this.cqq.cqm = true;
            this.cqq.aiH();
        }
    }
}
