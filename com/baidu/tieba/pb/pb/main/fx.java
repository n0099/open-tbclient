package com.baidu.tieba.pb.pb.main;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class fx implements View.OnClickListener {
    final /* synthetic */ ey etN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fx(ey eyVar) {
        this.etN = eyVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PbActivity pbActivity;
        PbActivity pbActivity2;
        this.etN.aOF();
        pbActivity = this.etN.ekw;
        if (pbActivity.bQO != null) {
            pbActivity2 = this.etN.ekw;
            pbActivity2.bQO.onClick(view);
        }
    }
}
