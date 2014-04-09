package com.baidu.tieba;

import android.view.View;
/* loaded from: classes.dex */
final class m implements View.OnClickListener {
    final /* synthetic */ k a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(k kVar) {
        this.a = kVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        o oVar;
        oVar = this.a.k;
        oVar.a();
    }
}
