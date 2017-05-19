package com.baidu.tieba.personPolymeric.d;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements View.OnClickListener {
    final /* synthetic */ h eEy;
    private final /* synthetic */ com.baidu.tieba.personPolymeric.c.f eEz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar, com.baidu.tieba.personPolymeric.c.f fVar) {
        this.eEy = hVar;
        this.eEz = fVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.eEy.b(this.eEz);
    }
}
