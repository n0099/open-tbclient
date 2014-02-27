package com.baidu.tieba.mention;

import android.view.View;
/* loaded from: classes.dex */
final class e implements View.OnClickListener {
    final /* synthetic */ c a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(c cVar) {
        this.a = cVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        com.baidu.tieba.k kVar;
        kVar = this.a.s;
        kVar.finish();
    }
}
