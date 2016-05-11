package com.baidu.tieba.person;

import android.view.View;
/* loaded from: classes.dex */
class bc implements View.OnClickListener {
    final /* synthetic */ ay dwQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bc(ay ayVar) {
        this.dwQ = ayVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        bh bhVar;
        z = this.dwQ.dwM;
        if (!z) {
            ay ayVar = this.dwQ;
            bhVar = this.dwQ.dwI;
            ayVar.pageNum = bhVar.getData().getPage().pI() + 1;
            this.dwQ.dwM = true;
            this.dwQ.atN();
        }
    }
}
