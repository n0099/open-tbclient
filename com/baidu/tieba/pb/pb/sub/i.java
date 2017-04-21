package com.baidu.tieba.pb.pb.sub;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements View.OnClickListener {
    final /* synthetic */ NewSubPbActivity evm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(NewSubPbActivity newSubPbActivity) {
        this.evm = newSubPbActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        SubPbModel subPbModel;
        SubPbModel subPbModel2;
        subPbModel = this.evm.euV;
        if (subPbModel != null) {
            subPbModel2 = this.evm.euV;
            subPbModel2.FC();
        }
    }
}
