package com.baidu.tieba.pb.pb.sub;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements View.OnClickListener {
    final /* synthetic */ NewSubPbActivity euQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(NewSubPbActivity newSubPbActivity) {
        this.euQ = newSubPbActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        SubPbModel subPbModel;
        SubPbModel subPbModel2;
        subPbModel = this.euQ.euz;
        if (subPbModel != null) {
            subPbModel2 = this.euQ.euz;
            subPbModel2.Fe();
        }
    }
}
