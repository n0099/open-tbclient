package com.baidu.tieba.person;

import android.view.View;
/* loaded from: classes.dex */
class l implements View.OnClickListener {
    final /* synthetic */ k eQi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(k kVar) {
        this.eQi = kVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.eQi.dismiss();
    }
}
