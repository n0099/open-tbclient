package com.baidu.tieba.person;

import android.view.View;
/* loaded from: classes.dex */
class ba implements View.OnClickListener {
    final /* synthetic */ aw cqf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ba(aw awVar) {
        this.cqf = awVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        bf bfVar;
        z = this.cqf.cqb;
        if (!z) {
            aw awVar = this.cqf;
            bfVar = this.cqf.cpW;
            awVar.pageNum = bfVar.getData().getPage().rJ() + 1;
            this.cqf.cqb = true;
            this.cqf.aiH();
        }
    }
}
