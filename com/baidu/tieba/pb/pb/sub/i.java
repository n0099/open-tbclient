package com.baidu.tieba.pb.pb.sub;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements View.OnClickListener {
    final /* synthetic */ NewSubPbActivity eEs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(NewSubPbActivity newSubPbActivity) {
        this.eEs = newSubPbActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        bc bcVar;
        bc bcVar2;
        bcVar = this.eEs.eEb;
        if (bcVar != null) {
            bcVar2 = this.eEs.eEb;
            bcVar2.Ff();
        }
    }
}
