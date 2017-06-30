package com.baidu.tieba.personPolymeric.d;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements View.OnClickListener {
    final /* synthetic */ h eXw;
    private final /* synthetic */ com.baidu.tieba.personPolymeric.c.g eXx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar, com.baidu.tieba.personPolymeric.c.g gVar) {
        this.eXw = hVar;
        this.eXx = gVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.eXw.b(this.eXx);
    }
}
