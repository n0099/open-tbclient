package com.baidu.tieba.person.a;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aj implements View.OnClickListener {
    final /* synthetic */ ai dvJ;
    private final /* synthetic */ com.baidu.tieba.person.data.q dvK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(ai aiVar, com.baidu.tieba.person.data.q qVar) {
        this.dvJ = aiVar;
        this.dvK = qVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.dvJ.mp(this.dvK.aCa());
    }
}
