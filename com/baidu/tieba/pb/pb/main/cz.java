package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.tbadk.core.view.PbListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cz implements View.OnClickListener {
    final /* synthetic */ ci bMm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cz(ci ciVar) {
        this.bMm = ciVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PbListView pbListView;
        boolean z;
        pbListView = this.bMm.bMa;
        pbListView.startLoadData();
        if (this.bMm.bIm != null) {
            bf bfVar = this.bMm.bIm;
            z = this.bMm.bIO;
            bfVar.dH(z);
        }
        this.bMm.abf();
    }
}
