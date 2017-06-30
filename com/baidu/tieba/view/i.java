package com.baidu.tieba.view;

import android.view.View;
/* loaded from: classes.dex */
class i implements View.OnClickListener {
    private final /* synthetic */ r bzU;
    final /* synthetic */ h gah;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar, r rVar) {
        this.gah = hVar;
        this.bzU = rVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.personPolymeric.event.a aVar = new com.baidu.tieba.personPolymeric.event.a();
        aVar.bVd = 9;
        this.bzU.a(view, aVar);
    }
}
