package com.baidu.tieba.person;

import android.view.View;
/* loaded from: classes.dex */
class bb implements View.OnClickListener {
    final /* synthetic */ ax cYT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bb(ax axVar) {
        this.cYT = axVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        bg bgVar;
        z = this.cYT.cYP;
        if (!z) {
            ax axVar = this.cYT;
            bgVar = this.cYT.cYK;
            axVar.pageNum = bgVar.getData().getPage().st() + 1;
            this.cYT.cYP = true;
            this.cYT.atQ();
        }
    }
}
