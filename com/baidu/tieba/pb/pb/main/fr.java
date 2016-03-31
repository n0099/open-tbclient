package com.baidu.tieba.pb.pb.main;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class fr implements View.OnClickListener {
    final /* synthetic */ eu dnc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fr(eu euVar) {
        this.dnc = euVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PbActivity pbActivity;
        PbActivity pbActivity2;
        this.dnc.azg();
        pbActivity = this.dnc.dfw;
        if (pbActivity.boQ != null) {
            pbActivity2 = this.dnc.dfw;
            pbActivity2.boQ.onClick(view);
        }
    }
}
