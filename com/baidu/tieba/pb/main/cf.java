package com.baidu.tieba.pb.main;

import android.view.View;
import com.baidu.tieba.view.PbListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cf implements View.OnClickListener {
    final /* synthetic */ bv byI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cf(bv bvVar) {
        this.byI = bvVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PbListView pbListView;
        boolean z;
        pbListView = this.byI.byA;
        pbListView.YH();
        if (this.byI.buX != null) {
            bg bgVar = this.byI.buX;
            z = this.byI.bvx;
            bgVar.dU(z);
        }
        this.byI.XU();
    }
}
