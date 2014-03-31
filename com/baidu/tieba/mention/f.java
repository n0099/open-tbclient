package com.baidu.tieba.mention;

import android.view.View;
/* loaded from: classes.dex */
final class f implements View.OnClickListener {
    final /* synthetic */ c a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(c cVar) {
        this.a = cVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        com.baidu.tbadk.core.e eVar;
        eVar = this.a.n;
        eVar.finish();
    }
}
