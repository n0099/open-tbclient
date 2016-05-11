package com.baidu.tieba.pb.pb.main;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class fi implements View.OnClickListener {
    final /* synthetic */ el dpu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fi(el elVar) {
        this.dpu = elVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PbActivity pbActivity;
        PbActivity pbActivity2;
        this.dpu.azy();
        pbActivity = this.dpu.dhY;
        if (pbActivity.bjV != null) {
            pbActivity2 = this.dpu.dhY;
            pbActivity2.bjV.onClick(view);
        }
    }
}
