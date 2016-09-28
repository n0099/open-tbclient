package com.baidu.tieba.personPolymeric.d;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements View.OnClickListener {
    final /* synthetic */ h eLp;
    private final /* synthetic */ com.baidu.tieba.personPolymeric.c.f eLq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar, com.baidu.tieba.personPolymeric.c.f fVar) {
        this.eLp = hVar;
        this.eLq = fVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.eLp.b(this.eLq);
    }
}
