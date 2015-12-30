package com.baidu.tieba.person;

import android.view.View;
/* loaded from: classes.dex */
class bb implements View.OnClickListener {
    final /* synthetic */ ax cPw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bb(ax axVar) {
        this.cPw = axVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        bg bgVar;
        z = this.cPw.cPs;
        if (!z) {
            ax axVar = this.cPw;
            bgVar = this.cPw.cPn;
            axVar.pageNum = bgVar.getData().getPage().rM() + 1;
            this.cPw.cPs = true;
            this.cPw.aoX();
        }
    }
}
