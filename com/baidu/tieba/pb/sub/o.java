package com.baidu.tieba.pb.sub;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements View.OnClickListener {
    final /* synthetic */ l bGx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(l lVar) {
        this.bGx = lVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        z = this.bGx.bGv;
        if (z) {
            this.bGx.aah();
        } else {
            this.bGx.hJ(null);
        }
    }
}
