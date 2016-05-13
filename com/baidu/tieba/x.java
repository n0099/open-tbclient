package com.baidu.tieba;

import android.view.View;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
class x implements View.OnClickListener {
    final /* synthetic */ u aHF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(u uVar) {
        this.aHF = uVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        u.a aVar;
        aVar = this.aHF.aHA;
        aVar.HR();
    }
}
