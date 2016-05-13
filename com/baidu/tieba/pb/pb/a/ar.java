package com.baidu.tieba.pb.pb.a;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ar implements View.OnClickListener {
    final /* synthetic */ ao dhe;
    private final /* synthetic */ int dhf;
    private final /* synthetic */ com.baidu.tieba.tbadkCore.data.s dhg;
    private final /* synthetic */ int val$count;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ar(ao aoVar, int i, int i2, com.baidu.tieba.tbadkCore.data.s sVar) {
        this.dhe = aoVar;
        this.dhf = i;
        this.val$count = i2;
        this.dhg = sVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.dhg.po(Math.min(this.dhf + 5, this.val$count));
        this.dhe.notifyDataSetChanged();
    }
}
