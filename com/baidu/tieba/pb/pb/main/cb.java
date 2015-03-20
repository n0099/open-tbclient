package com.baidu.tieba.pb.pb.main;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cb implements View.OnClickListener {
    final /* synthetic */ by bJN;
    private final /* synthetic */ int bJR;
    private final /* synthetic */ com.baidu.tieba.tbadkCore.c.j bJS;
    private final /* synthetic */ int val$count;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cb(by byVar, int i, int i2, com.baidu.tieba.tbadkCore.c.j jVar) {
        this.bJN = byVar;
        this.bJR = i;
        this.val$count = i2;
        this.bJS = jVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.bJS.is(Math.min(this.bJR + 5, this.val$count));
        this.bJN.notifyDataSetChanged();
    }
}
