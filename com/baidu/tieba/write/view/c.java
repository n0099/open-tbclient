package com.baidu.tieba.write.view;

import android.view.View;
/* loaded from: classes.dex */
class c implements View.OnClickListener {
    final /* synthetic */ a eqd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.eqd = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.eqd.afm();
    }
}
