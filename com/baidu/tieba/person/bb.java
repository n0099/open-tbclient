package com.baidu.tieba.person;

import android.view.View;
/* loaded from: classes.dex */
class bb implements View.OnClickListener {
    final /* synthetic */ ax cLg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bb(ax axVar) {
        this.cLg = axVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        bg bgVar;
        z = this.cLg.cLc;
        if (!z) {
            ax axVar = this.cLg;
            bgVar = this.cLg.cKX;
            axVar.pageNum = bgVar.getData().getPage().sd() + 1;
            this.cLg.cLc = true;
            this.cLg.anM();
        }
    }
}
