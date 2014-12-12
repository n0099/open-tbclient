package com.baidu.tieba.pb.main;

import android.view.View;
import com.baidu.tbadk.core.view.PbListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cj implements View.OnClickListener {
    final /* synthetic */ bz bCR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cj(bz bzVar) {
        this.bCR = bzVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PbListView pbListView;
        boolean z;
        pbListView = this.bCR.bCH;
        pbListView.startLoadData();
        if (this.bCR.bza != null) {
            bh bhVar = this.bCR.bza;
            z = this.bCR.bzA;
            bhVar.dF(z);
        }
        this.bCR.Yv();
    }
}
