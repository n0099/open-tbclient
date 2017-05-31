package com.baidu.tieba.view;

import android.view.View;
/* loaded from: classes.dex */
class i implements View.OnClickListener {
    private final /* synthetic */ r byY;
    final /* synthetic */ h fQq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar, r rVar) {
        this.fQq = hVar;
        this.byY = rVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.personPolymeric.event.a aVar = new com.baidu.tieba.personPolymeric.event.a();
        aVar.bOi = 9;
        this.byY.a(view, aVar);
    }
}
