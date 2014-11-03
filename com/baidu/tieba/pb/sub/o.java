package com.baidu.tieba.pb.sub;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements View.OnClickListener {
    final /* synthetic */ l bAZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(l lVar) {
        this.bAZ = lVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        z = this.bAZ.bAX;
        if (z) {
            this.bAZ.Zg();
        } else {
            this.bAZ.hd(null);
        }
    }
}
