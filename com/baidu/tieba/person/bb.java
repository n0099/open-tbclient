package com.baidu.tieba.person;

import android.view.View;
/* loaded from: classes.dex */
class bb implements View.OnClickListener {
    final /* synthetic */ ax dtv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bb(ax axVar) {
        this.dtv = axVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        bg bgVar;
        z = this.dtv.dtr;
        if (!z) {
            ax axVar = this.dtv;
            bgVar = this.dtv.dtm;
            axVar.pageNum = bgVar.getData().getPage().so() + 1;
            this.dtv.dtr = true;
            this.dtv.aBw();
        }
    }
}
