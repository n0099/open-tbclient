package com.baidu.tieba.view;

import android.view.View;
/* loaded from: classes.dex */
class i implements View.OnClickListener {
    final /* synthetic */ h fVY;
    private final /* synthetic */ m fVZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar, m mVar) {
        this.fVY = hVar;
        this.fVZ = mVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.personPolymeric.event.a aVar = new com.baidu.tieba.personPolymeric.event.a();
        aVar.bJp = 9;
        this.fVZ.a(view, aVar);
    }
}
