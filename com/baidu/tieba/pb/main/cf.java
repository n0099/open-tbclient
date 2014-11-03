package com.baidu.tieba.pb.main;

import android.view.View;
import com.baidu.tieba.view.PbListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cf implements View.OnClickListener {
    final /* synthetic */ bv byW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cf(bv bvVar) {
        this.byW = bvVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PbListView pbListView;
        boolean z;
        pbListView = this.byW.byO;
        pbListView.YK();
        if (this.byW.bvl != null) {
            bg bgVar = this.byW.bvl;
            z = this.byW.bvL;
            bgVar.dU(z);
        }
        this.byW.XX();
    }
}
