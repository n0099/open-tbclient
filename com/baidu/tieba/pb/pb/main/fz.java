package com.baidu.tieba.pb.pb.main;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class fz implements View.OnClickListener {
    final /* synthetic */ fa etn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fz(fa faVar) {
        this.etn = faVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PbActivity pbActivity;
        PbActivity pbActivity2;
        this.etn.aNv();
        pbActivity = this.etn.eka;
        if (pbActivity.bOI != null) {
            pbActivity2 = this.etn.eka;
            pbActivity2.bOI.onClick(view);
        }
    }
}
