package com.baidu.tieba.pb.pb.main;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class dk implements View.OnClickListener {
    private final /* synthetic */ int cLw;
    private final /* synthetic */ com.baidu.tieba.tbadkCore.data.r cLx;
    final /* synthetic */ de cPG;
    private final /* synthetic */ int val$count;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dk(de deVar, int i, int i2, com.baidu.tieba.tbadkCore.data.r rVar) {
        this.cPG = deVar;
        this.cLw = i;
        this.val$count = i2;
        this.cLx = rVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.cLx.ok(Math.min(this.cLw + 5, this.val$count));
        this.cPG.notifyDataSetChanged();
    }
}
