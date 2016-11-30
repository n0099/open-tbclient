package com.baidu.tieba.pb.pb.main;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class fw implements View.OnClickListener {
    final /* synthetic */ ey eCT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fw(ey eyVar) {
        this.eCT = eyVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PbActivity pbActivity;
        PbActivity pbActivity2;
        this.eCT.aSs();
        pbActivity = this.eCT.eug;
        if (pbActivity.bTO != null) {
            pbActivity2 = this.eCT.eug;
            pbActivity2.bTO.onClick(view);
        }
    }
}
