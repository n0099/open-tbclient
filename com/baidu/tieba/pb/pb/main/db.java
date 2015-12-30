package com.baidu.tieba.pb.pb.main;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class db implements View.OnClickListener {
    private final /* synthetic */ int cEg;
    private final /* synthetic */ com.baidu.tieba.tbadkCore.data.r cEh;
    final /* synthetic */ cx cHX;
    private final /* synthetic */ int val$count;

    /* JADX INFO: Access modifiers changed from: package-private */
    public db(cx cxVar, int i, int i2, com.baidu.tieba.tbadkCore.data.r rVar) {
        this.cHX = cxVar;
        this.cEg = i;
        this.val$count = i2;
        this.cEh = rVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.cEh.mZ(Math.min(this.cEg + 5, this.val$count));
        this.cHX.notifyDataSetChanged();
    }
}
