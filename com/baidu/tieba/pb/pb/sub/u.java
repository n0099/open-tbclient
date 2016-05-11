package com.baidu.tieba.pb.pb.sub;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u implements View.OnClickListener {
    final /* synthetic */ NewSubPbActivity dqn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(NewSubPbActivity newSubPbActivity) {
        this.dqn = newSubPbActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ap apVar;
        ap apVar2;
        apVar = this.dqn.dqc;
        if (apVar != null) {
            apVar2 = this.dqn.dqc;
            apVar2.Dy();
        }
    }
}
