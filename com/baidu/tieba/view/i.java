package com.baidu.tieba.view;

import android.view.View;
/* loaded from: classes.dex */
class i implements View.OnClickListener {
    final /* synthetic */ h fut;
    private final /* synthetic */ m fuu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar, m mVar) {
        this.fut = hVar;
        this.fuu = mVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.personPolymeric.event.a aVar = new com.baidu.tieba.personPolymeric.event.a();
        aVar.bsn = 9;
        this.fuu.a(view, aVar);
    }
}
