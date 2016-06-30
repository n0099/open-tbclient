package com.baidu.tieba.pb.pb.main;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class fp implements View.OnClickListener {
    final /* synthetic */ es dVR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fp(es esVar) {
        this.dVR = esVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PbActivity pbActivity;
        PbActivity pbActivity2;
        this.dVR.aHN();
        pbActivity = this.dVR.dOg;
        if (pbActivity.bFi != null) {
            pbActivity2 = this.dVR.dOg;
            pbActivity2.bFi.onClick(view);
        }
    }
}
