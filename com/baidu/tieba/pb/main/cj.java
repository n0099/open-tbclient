package com.baidu.tieba.pb.main;

import android.view.View;
import com.baidu.tbadk.core.view.PbListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cj implements View.OnClickListener {
    final /* synthetic */ bz bEB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cj(bz bzVar) {
        this.bEB = bzVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PbListView pbListView;
        boolean z;
        pbListView = this.bEB.bEr;
        pbListView.startLoadData();
        if (this.bEB.bAJ != null) {
            bh bhVar = this.bEB.bAJ;
            z = this.bEB.bBj;
            bhVar.dL(z);
        }
        this.bEB.YV();
    }
}
