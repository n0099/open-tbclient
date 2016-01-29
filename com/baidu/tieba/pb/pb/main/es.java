package com.baidu.tieba.pb.pb.main;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class es implements View.OnClickListener {
    final /* synthetic */ dz cSw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public es(dz dzVar) {
        this.cSw = dzVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PbActivity pbActivity;
        PbActivity pbActivity2;
        this.cSw.arF();
        pbActivity = this.cSw.cNL;
        if (pbActivity.bjG != null) {
            pbActivity2 = this.cSw.cNL;
            pbActivity2.bjG.onClick(view);
        }
    }
}
