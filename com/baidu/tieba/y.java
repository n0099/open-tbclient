package com.baidu.tieba;

import android.view.View;
import com.baidu.tieba.v;
/* loaded from: classes.dex */
class y implements View.OnClickListener {
    final /* synthetic */ v aMp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(v vVar) {
        this.aMp = vVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        v.a aVar;
        aVar = this.aMp.aMk;
        aVar.Jk();
    }
}
