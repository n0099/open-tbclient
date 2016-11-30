package com.baidu.tieba;

import android.view.View;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
class w implements View.OnClickListener {
    final /* synthetic */ t aPF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(t tVar) {
        this.aPF = tVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        t.a aVar;
        aVar = this.aPF.aPA;
        aVar.KA();
    }
}
