package com.baidu.tieba.person.a;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aq implements View.OnClickListener {
    final /* synthetic */ ap dyL;
    private final /* synthetic */ com.baidu.tieba.person.data.t dyM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aq(ap apVar, com.baidu.tieba.person.data.t tVar) {
        this.dyL = apVar;
        this.dyM = tVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.dyL.mt(this.dyM.aCx());
    }
}
