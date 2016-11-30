package com.baidu.tieba.view;

import android.view.View;
/* loaded from: classes.dex */
class i implements View.OnClickListener {
    final /* synthetic */ h gfy;
    private final /* synthetic */ m gfz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar, m mVar) {
        this.gfy = hVar;
        this.gfz = mVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.personPolymeric.event.a aVar = new com.baidu.tieba.personPolymeric.event.a();
        aVar.bMj = 9;
        this.gfz.a(view, aVar);
    }
}
