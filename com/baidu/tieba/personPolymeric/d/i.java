package com.baidu.tieba.personPolymeric.d;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements View.OnClickListener {
    final /* synthetic */ h evm;
    private final /* synthetic */ com.baidu.tieba.personPolymeric.c.f evn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar, com.baidu.tieba.personPolymeric.c.f fVar) {
        this.evm = hVar;
        this.evn = fVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.evm.b(this.evn);
    }
}
