package com.baidu.tieba;

import android.view.View;
import com.baidu.tieba.j;
/* loaded from: classes.dex */
class m implements View.OnClickListener {
    final /* synthetic */ j aEf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(j jVar) {
        this.aEf = jVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        j.a aVar;
        aVar = this.aEf.aEa;
        aVar.FI();
    }
}
