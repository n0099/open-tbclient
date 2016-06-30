package com.baidu.tieba;

import android.view.View;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
class z implements View.OnClickListener {
    final /* synthetic */ w aIh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(w wVar) {
        this.aIh = wVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        w.a aVar;
        aVar = this.aIh.aIc;
        aVar.HS();
    }
}
