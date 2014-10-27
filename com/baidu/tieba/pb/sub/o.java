package com.baidu.tieba.pb.sub;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements View.OnClickListener {
    final /* synthetic */ l bAL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(l lVar) {
        this.bAL = lVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        z = this.bAL.bAJ;
        if (z) {
            this.bAL.Zd();
        } else {
            this.bAL.hd(null);
        }
    }
}
