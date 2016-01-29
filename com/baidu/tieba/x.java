package com.baidu.tieba;

import android.view.View;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
class x implements View.OnClickListener {
    final /* synthetic */ u aIy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(u uVar) {
        this.aIy = uVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        u.a aVar;
        aVar = this.aIy.aIt;
        aVar.Ic();
    }
}
