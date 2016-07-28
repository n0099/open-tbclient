package com.baidu.tieba.pb.pb.main;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ft implements View.OnClickListener {
    final /* synthetic */ ew eiu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ft(ew ewVar) {
        this.eiu = ewVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PbActivity pbActivity;
        PbActivity pbActivity2;
        this.eiu.aKX();
        pbActivity = this.eiu.eat;
        if (pbActivity.bGw != null) {
            pbActivity2 = this.eiu.eat;
            pbActivity2.bGw.onClick(view);
        }
    }
}
