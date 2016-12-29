package com.baidu.tieba.pb.pb.main;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class fp implements View.OnClickListener {
    final /* synthetic */ er egZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fp(er erVar) {
        this.egZ = erVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PbActivity pbActivity;
        PbActivity pbActivity2;
        this.egZ.aMl();
        pbActivity = this.egZ.dYB;
        if (pbActivity.bzZ != null) {
            pbActivity2 = this.egZ.dYB;
            pbActivity2.bzZ.onClick(view);
        }
    }
}
