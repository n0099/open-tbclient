package com.baidu.tieba.pb.pb.sub;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements View.OnClickListener {
    final /* synthetic */ l bOv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(l lVar) {
        this.bOv = lVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        z = this.bOv.bOr;
        if (z) {
            this.bOv.acB();
        } else {
            this.bOv.hT(null);
        }
    }
}
