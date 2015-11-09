package com.baidu.tieba.pb.pb.sub;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements View.OnClickListener {
    final /* synthetic */ NewSubPbActivity cnS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(NewSubPbActivity newSubPbActivity) {
        this.cnS = newSubPbActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        am amVar;
        am amVar2;
        amVar = this.cnS.cnH;
        if (amVar != null) {
            amVar2 = this.cnS.cnH;
            amVar2.CI();
        }
    }
}
