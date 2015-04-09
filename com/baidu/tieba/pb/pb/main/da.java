package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.tbadk.core.view.PbListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class da implements View.OnClickListener {
    final /* synthetic */ cj bMC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public da(cj cjVar) {
        this.bMC = cjVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PbListView pbListView;
        boolean z;
        pbListView = this.bMC.bMq;
        pbListView.startLoadData();
        if (this.bMC.bIA != null) {
            bg bgVar = this.bMC.bIA;
            z = this.bMC.bJc;
            bgVar.dF(z);
        }
        this.bMC.abt();
    }
}
