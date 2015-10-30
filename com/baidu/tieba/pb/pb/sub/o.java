package com.baidu.tieba.pb.pb.sub;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements View.OnClickListener {
    final /* synthetic */ NewSubPbActivity cmC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(NewSubPbActivity newSubPbActivity) {
        this.cmC = newSubPbActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ak akVar;
        ak akVar2;
        akVar = this.cmC.cmt;
        if (akVar != null) {
            akVar2 = this.cmC.cmt;
            akVar2.CP();
        }
    }
}
