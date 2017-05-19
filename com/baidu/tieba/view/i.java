package com.baidu.tieba.view;

import android.view.View;
/* loaded from: classes.dex */
class i implements View.OnClickListener {
    final /* synthetic */ h fIw;
    private final /* synthetic */ p fIx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar, p pVar) {
        this.fIw = hVar;
        this.fIx = pVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.personPolymeric.event.a aVar = new com.baidu.tieba.personPolymeric.event.a();
        aVar.bIu = 9;
        this.fIx.a(view, aVar);
    }
}
