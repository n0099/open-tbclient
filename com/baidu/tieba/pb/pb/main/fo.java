package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.tieba.pb.pb.main.PbActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class fo implements View.OnClickListener {
    final /* synthetic */ es dVR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fo(es esVar) {
        this.dVR = esVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PbActivity pbActivity;
        boolean z;
        pbActivity = this.dVR.dOg;
        if (pbActivity.checkUpIsLogin()) {
            this.dVR.asK();
            if (this.dVR.dPr != null) {
                PbActivity.c cVar = this.dVR.dPr;
                z = this.dVR.dNd;
                cVar.hu(z);
            }
            this.dVR.aHy();
        }
    }
}
