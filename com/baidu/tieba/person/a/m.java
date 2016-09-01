package com.baidu.tieba.person.a;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements View.OnClickListener {
    final /* synthetic */ l eBU;
    private final /* synthetic */ com.baidu.tieba.person.data.c eBV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(l lVar, com.baidu.tieba.person.data.c cVar) {
        this.eBU = lVar;
        this.eBV = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.eBU.pq(this.eBV.aSh());
    }
}
