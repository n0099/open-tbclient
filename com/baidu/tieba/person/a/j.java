package com.baidu.tieba.person.a;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements View.OnClickListener {
    final /* synthetic */ i eye;
    private final /* synthetic */ com.baidu.tieba.person.data.c eyf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(i iVar, com.baidu.tieba.person.data.c cVar) {
        this.eye = iVar;
        this.eyf = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.eye.oI(this.eyf.aQB());
    }
}
