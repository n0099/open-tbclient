package com.baidu.tieba.person.a;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ar implements View.OnClickListener {
    final /* synthetic */ aq ehq;
    private final /* synthetic */ com.baidu.tieba.person.data.t ehr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ar(aq aqVar, com.baidu.tieba.person.data.t tVar) {
        this.ehq = aqVar;
        this.ehr = tVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.ehq.nZ(this.ehr.aLq());
    }
}
