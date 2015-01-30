package com.baidu.tieba.pb.main;

import android.view.View;
import com.baidu.tbadk.core.view.PbListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cj implements View.OnClickListener {
    final /* synthetic */ bz bEC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cj(bz bzVar) {
        this.bEC = bzVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PbListView pbListView;
        boolean z;
        pbListView = this.bEC.bEs;
        pbListView.startLoadData();
        if (this.bEC.bAK != null) {
            bh bhVar = this.bEC.bAK;
            z = this.bEC.bBk;
            bhVar.dL(z);
        }
        this.bEC.Za();
    }
}
