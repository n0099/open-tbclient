package com.baidu.tieba.pb.pb.sub;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements View.OnClickListener {
    final /* synthetic */ NewSubPbActivity cfY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(NewSubPbActivity newSubPbActivity) {
        this.cfY = newSubPbActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ak akVar;
        ak akVar2;
        akVar = this.cfY.cfP;
        if (akVar != null) {
            akVar2 = this.cfY.cfP;
            akVar2.CV();
        }
    }
}
