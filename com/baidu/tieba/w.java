package com.baidu.tieba;

import android.view.View;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
class w implements View.OnClickListener {
    final /* synthetic */ t aOW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(t tVar) {
        this.aOW = tVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        t.a aVar;
        aVar = this.aOW.aOR;
        aVar.JT();
    }
}
